package com.fxy.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fxy.bean.Folder;
import com.fxy.service.FolderService;

@Controller
public class ShowAllFolderController {
	@Autowired
	private FolderService folderService;
	protected static final Logger logger = LoggerFactory.getLogger(ShowAllFolderController.class);
	/**
	 * 单个文件删除
	 * @param request
	 * @param rename
	 * @param path
	 * @return
	 */
	@RequestMapping(value = "showAllFolder")
	public String showAllFolder(HttpServletRequest request) {
		logger.info("showAllFolder加载完毕");
		
		// 获得全部的文件夹，在页面中显示
		List<Folder> lFolders = folderService.selectAll();
		request.getSession().setAttribute("lFolders", lFolders);
		
		return "allFolder";
	}
}
