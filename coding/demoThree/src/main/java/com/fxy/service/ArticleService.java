package com.fxy.service;


import com.fxy.bean.Article;

public interface ArticleService {
	
	/**
	 * @Title: addArticle
	 * @Description: 把新发表的文章插入数据库
	 * @param article
	 * @return int
	 * @throws 
	 * @author fxy 
	 * @date 2018年3月6日
	 */
	int addArticle(Article article);

	/**
	 * @Title: countById 
	 * @Description: 获得没修改主次评论前的评论数
	 * @param article_id
	 * @return         
	 * @throws 
	 * @author: fxy
	 * @date: 2017年12月9日
	 */
	int countById(int article_id);

	
	/**
	 * @Title: addComments 
	 * @Description: 根据文章id把文章表中的评论数comments+1
	 * @param article_id
	 * @return int        
	 * @throws 
	 * @author: fxy
	 * @date: 2017年12月9日
	 */
	int addComments(Article article);
	
}
