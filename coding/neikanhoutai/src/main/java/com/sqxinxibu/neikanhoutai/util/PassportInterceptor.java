package com.sqxinxibu.neikanhoutai.util;

import com.sqxinxibu.neikanhoutai.entity.LoginTicket;
import com.sqxinxibu.neikanhoutai.service.Impl.LoginTickerService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 拦截器
 * @ 用来判断用户的
 *1. 当preHandle方法返回false时，从当前拦截器往回执行所有拦截器的afterCompletion方法，再退出拦截器链。也就是说，请求不继续往下传了，直接沿着来的链往回跑。
 2.当preHandle方法全为true时，执行下一个拦截器,直到所有拦截器执行完。再运行被拦截的Controller。然后进入拦截器链，运
 行所有拦截器的postHandle方法,完后从最后一个拦截器往回执行所有拦截器的afterCompletion方法.
 */

//@component （把普通pojo实例化到spring容器中，相当于配置文件中的
@Component
public class PassportInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginTickerService loginTickerService;
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println("拦截器preHandle方法");
        String token = request.getParameter("token");
        System.out.println("拦截器token："+token);
        //先判断是否存在问题
        if (token==null||token.length() <= 0){
            PrintWriter writer = null;
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
            try {
                writer = response.getWriter();
                String error = "请先登录";
                writer.print(error);
                return false;

            } catch (IOException e) {
                System.out.println("错误："+e);
            } finally {
                if (writer != null)
                    writer.close();
            }
        }

        if (loginTickerService == null) {//解决service为null无法注入问题
            System.out.println("loginTickerService is null!!!");
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            loginTickerService = (LoginTickerService) factory.getBean("loginTickerService");
        }
        //根据token往数据库里查询token是否存在
        LoginTicket chauxntoken=loginTickerService.chaxunByLoginTicket(token);
        //System.out.println("查询到的ticket:"+ JSON.toJSONString(chauxntoken));
        if (chauxntoken==null){
            PrintWriter writer = null;
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
            try {
                writer = response.getWriter();
                String error = "token错误或不存在";
                writer.print(error);
                return false;

            } catch (IOException e) {
                System.out.println("错误："+e);
            } finally {
                if (writer != null)
                    writer.close();
            }
        }
        return true;

    }
    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
