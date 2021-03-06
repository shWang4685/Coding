package com.fxy.service;

import com.fxy.bean.Comment;

public interface CommentService {
	/**
	 * @Title: insertMainComment
	 * @param content
	 * @param user_id
	 * @param article_id
	 * @return
	 * @Description: 插入主评论
	 * @author: fxy
	 * @date: 2017年12月7日
	 */
	public int insertMainComment(Comment comment);
	

	/**
	 * @Title: deleteByPrimaryKey
	 * @param id
	 * @return 
	 * @Description: 根据Id删除主评论
	 * @author: fxy
	 * @date: 2017年12月8日
	 */
	public int deleteByPrimaryKey(int id);
	
	/**
	 * @Title: updateByPrimaryKeySelective 
	 * @Description: 根据id跟comment_replies选择性的修改comment表
	 * @param comment
	 * @return int        
	 * @throws 
	 * @author: fxy
	 * @date: 2017年12月9日
	 */
	public int updateByPrimaryKeySelective(Comment comment);
	
	/**
	 * @Title: selectByCommentId 
	 * @Description: 通过主评论的id获得文章的id
	 * @param comment_id
	 * @return   int      
	 * @throws 
	 * @author: fxy
	 * @date: 2017年12月9日
	 */
	public int selectByCommentId(int comment_id);

	
	
}
