package com.fxy.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.fxy.bean.Comment;
import com.fxy.bean.User;
import com.fxy.service.ArticleService;
import com.fxy.service.CommentService;
import com.fxy.service.UserService;

@Controller
public class CommentController {
	@Autowired
	private ArticleService articleService;

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	protected static final Logger log = LoggerFactory.getLogger(CommentController.class);

	/**
	 * @Title: commentArticle
	 * @Description: 添加逐鹿
	 * @param request
	 * @param idArticle
	 * @param userIdArticle
	 * @param inputComment
	 * @return Msg
	 * @throws 
	 * @author fxy 
	 * @date 2018年3月7日
	 */
	//TODO:Comment中的countById方法没有
	@ResponseBody
	@RequestMapping(value = "/article/commentArticle", method = RequestMethod.POST)
	public Msg commentArticle(HttpServletRequest request,int idArticle, String inputComment) {

		// 获得没插入该主评论前的评论数
		int intComments = articleService.countById(idArticle);
		
		if (0 != intComments ) {
			// 评论数+1
			intComments = intComments + 1;
		}else{
			
			intComments = 1;
		}
		
		// 把已经+1的评论数封装到article表
		Article article = new Article();
		article.setId(idArticle);
		article.setComments(intComments);

		int intFlagAddComments = articleService.addComments(article);
		log.info("article文章表的评论数+1成功返回1:" + intFlagAddComments);
		
		// 刚刚添加主评论的时候 次评论数都为0
		int commentReplies = 0;
		// 设置主评论的时间
		Date date = new Date();

		//获得主评论用户的ID
		HttpSession session = request.getSession();
		int intUserId  = (int) session.getAttribute("intUserId");
		
		// 封装传过来的值
		Comment comment = new Comment();
		comment.setContent(inputComment);
		comment.setArticleId(idArticle);
		comment.setPublishTime(date);
		comment.setUserId(intUserId);
		comment.setCommentReplies(commentReplies);

		// 调用插入数据库函数
		int intFlagInsertComment = commentService.insertMainComment(comment);
		// 插入成功，返回1
		log.info("主评论插入成功返回1-->flag:" + intFlagInsertComment);
  
		//根据用户ID获得主评论用户的用户名User selectByPrimaryKey(Integer id)
		User userForName = userService.selectByIdForName(intUserId);
		String strName = userForName.getName();
		return Msg.success().add("comment", comment).add("commentUserName", strName);
		
	}
}
