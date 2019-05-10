package com.fxy.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fxy.assist.ErrEnum;
import com.fxy.assist.Msg;
import com.fxy.bean.Article;
import com.fxy.bean.User;
import com.fxy.service.ArticleService;
import com.fxy.service.UserService;
@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private UserService userService;
	
	protected static final Logger log = LoggerFactory.getLogger(ArticleController.class);

	/**
	 * @Title: PublishArticle 
	 * @Description:  发表文章,传title、content、user_id(存到session)
	 * publish_time、comments默认为0
	 * @param request
	 * @param inputTitle
	 * @param inputContent
	 * @return Msg    
	 * @throws 
	 * @author fxy 
	 * @date 2018年3月5日
	 */
	@ResponseBody
	@RequestMapping(value = "/article/publishArticle", method = RequestMethod.POST)
	public Msg PublishArticle(HttpServletRequest request, String inputTitle, String inputContent) {
		log.info(inputTitle);
		HttpSession session = request.getSession();
		int intUserId =  (int) session.getAttribute("intUserId");
		log.info("intUserId:"+intUserId);
		
		//把内容封装到数据库Article表
		Article article = new Article();
		article.setTitle(inputTitle);
		article.setContent(inputContent);
		article.setPublishTime(new Date());
		//最开始发表，评论数为0
		article.setComments(0);
		article.setUserId(intUserId);
		//把新发表的文章插入数据库
		int intFlagArticle = articleService.addArticle(article);
		
		//
		log.info("article.getId():"+article.getId());
		if (0 != intFlagArticle ) {
			
			//先获得该用户id已经发表的文章数
			int intCountArticles = userService.selectByIdForArticles(intUserId);
			
			//封装发表文章后的用户信息
			User user = new User();
			user.setId(intUserId);
			user.setArticles(intCountArticles);
			
			//根据用户ID把用户发表的文章数加1
			int intFlagUserArticlesAdd = userService.addArticles(user); 
			//如果成功
			if (0 != intFlagUserArticlesAdd) {
				return Msg.success().add("article", article);
			} else {
				return Msg.error().add("errMsg", ErrEnum.ADD_ERROR.getErrorMessage());
			}
			
		} else {
			return Msg.error().add("errMsg", ErrEnum.ADD_ERROR.getErrorMessage());
		}
		
	}
	
	
	/**
	 * @Title: ShowAllArticle
	 * @Description: 显示全部文章
	 * @param request
	 * @return Msg
	 * @throws 
	 * @author fxy 
	 * @date 2018年3月7日
	 */
	@ResponseBody
	@RequestMapping(value = "/article/showArticle", method = RequestMethod.POST)
	public Msg ShowArticle(HttpServletRequest request) {
		/*
		//TODO:
		//获得全部文章
		List<Article> articleList = articleService.showAllArticle();
		
		//遍历显示文章
		for (Article article : articleList) {
			log.info("article:"+article.getContent());
		}
		
		return Msg.success().add("articleList", articleList);*/
		return Msg.success();
	}
	
}