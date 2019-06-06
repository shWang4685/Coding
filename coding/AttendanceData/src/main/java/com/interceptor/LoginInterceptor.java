package com.interceptor;


import com.entity.CompanyUser;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 登录验证拦截
 *
 */
@Controller
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	Logger log = Logger.getLogger(LoginInterceptor.class);
	
	/*@Autowired
	UserService userService;*/
	
	/*@Value("${IGNORE_LOGIN}")
	Boolean IGNORE_LOGIN;*/

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String basePath = request.getContextPath();
		String path = request.getRequestURI();
//		log.info("basePath:"+basePath);
//		log.info("path:"+path);
		
		if(!doLoginInterceptor(path, basePath) ){//是否进行登陆拦截
			return true;
		}
		
//		HttpSession session = request.getSession();
//		int userID = 2;
//		UserInfo userInfo = sysUserService.getUserInfoByUserID(userID);
//		System.out.println(JsonUtil.toJson(userInfo));
//		session.setAttribute(Constants.SessionKey.USER, userInfo);
		
		//如果登录了，会把用户信息存进session
		HttpSession session = request.getSession();
		CompanyUser users =  (CompanyUser) session.getAttribute("CompanyUser");

		/*User userInfo = new User();
		userInfo.setId(users.get(0).getId());
		userInfo.setName(users.get(0).getName());
		userInfo.setPassword(users.get(0).getPassword());*/
		//开发环节的设置，不登录的情况下自动登录
		/*if(userInfo==null && IGNORE_LOGIN){
			userInfo = sysUserService.getUserInfoByUserID(2);
			session.setAttribute(Constants.SessionKey.USER, userInfo);
		}*/
		if(users==null){
			String requestType = request.getHeader("X-Requested-With");
			if(requestType!=null && requestType.equals("XMLHttpRequest")){
				response.setHeader("sessionstatus","timeout");
				response.getWriter().print("LoginTimeout");
				return false;
			} else {
				log.info("尚未登录，跳转到登录界面");
				response.sendRedirect("http://192.168.71.211:8888/login");
			}
			return false;
		}else {
			//拦截admin下的请求，如果权限等级为0/1 正常，如果权限等级为2/3返回到getAllEmp 请求
			String indexStr=request.getRequestURI().substring(request.getContextPath().indexOf("/")+1);
			if(indexStr.indexOf("admin")!=-1){
				if(users.getUser_permission()==2){
					response.sendRedirect("http://192.168.71.211:8888/getAllEmp");
					return false;
				}else if(users.getUser_permission()==3){
					response.sendRedirect("http://192.168.71.211:8888/getAllEmp");
					return false;
				}
			}

		}
//		log.info("用户已登录,userName:"+userInfo.getSysUser().getUserName());
		return true;
	}
	
	/**
	 * 是否进行登陆过滤
	 * @param path
	 * @param basePath
	 * @return
	 */
	private boolean doLoginInterceptor(String path,String basePath){
		path = path.substring(basePath.length());
		Set<String> notLoginPaths = new HashSet<>();
		//设置不进行登录拦截的路径：登录注册和验证码
		//notLoginPaths.add("/");
		notLoginPaths.add("/login");
		notLoginPaths.add("/logindemo");
		notLoginPaths.add("/regist");
		notLoginPaths.add("/registAction");
		notLoginPaths.add("/registActivation");
		notLoginPaths.add("/registSucess");
		notLoginPaths.add("/registFail");

		notLoginPaths.add("/uploadfile");
		notLoginPaths.add("/upload");
		notLoginPaths.add("/insertUserByExcel");
		notLoginPaths.add("/fruit/detail");
		notLoginPaths.add("/Thyleaf");


		//notLoginPaths.add("/tmpage");
	//	notLoginPaths.add("/allTMInfoPage");
		if(notLoginPaths.contains(path)) return false;
		return true;
	}
}
