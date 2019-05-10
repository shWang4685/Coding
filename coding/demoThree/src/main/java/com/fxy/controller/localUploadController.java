package com.fxy.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fxy.bean.FileList;
import com.fxy.bean.Folder;
import com.fxy.service.FileListService;
import com.fxy.service.FolderService;

@Controller
public class localUploadController {

	@Autowired
	private FolderService folderService;

	@Autowired
	private FileListService fileListService;

	protected static final Logger log = LoggerFactory.getLogger(localUploadController.class);

	/**
	 * @description 上传文件
	 * @param request
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "loadPathTwo", method = RequestMethod.POST)
	public String loadPathTwo(HttpServletRequest request, @RequestParam("file") MultipartFile[] file) {
		
		if (file.length == 0) {
			request.getSession().setAttribute("loadErr", "您没有输入文件名！");
			return "uploadTwo";
		} else {
		
			// 获得要上传的文件路径的ID
			int upIdTwo = (int) request.getSession().getAttribute("uploadIdTwo");
			log.info("upIdTwo:" + upIdTwo);
			// 判断fileList中是否有该id对应的值，因为他们是外键
			// 根据upId获得folder路径
			List<Folder> folderFilePathList = folderService.selectFolderById(upIdTwo);
			String uploadPath = folderFilePathList.get(0).getFolder() + "/";
			log.info("uploadPath:" + uploadPath);

			// 现在要上传的文件名
			String nowFileName = "";
			// 现在要上传的文件后缀
			String Suffix = "";
			// 判断是否上传和插入数据库成功
			int num = 0;
			boolean flag = false;

			// 根据id获得数据库中该路径下的所有文件名
			List<FileList> fileListName = fileListService.selectByIdTwo(upIdTwo);
			/*
			 * 切记:如果该id对应的属性不存在，这段代码就直接不执行 for (FileList fileList : fList) {
			 * log.info("fileList:"+fileList.getFilename()); }
			 */

			// 遍历上传的文件，得到文件名判断数据库中是否存在
			for (MultipartFile file1 : file) {
				// 获得上传的文件名
				nowFileName = file1.getOriginalFilename();
				log.info("nowFileName文件名:" + nowFileName);

				// 切记:因为为空，所以不执行
				// 一个下午都解决不了是因为头昏脑涨，把它当成string来判断是否为空了，切记切记！！！
				if (fileListName.size() == 0) {
					// 可以上传
					String lastUploadPath = uploadPath + nowFileName;
					flag = uplocal(file1, lastUploadPath);
					if (flag) {
						log.info("上传成功了。。。");
						// 把文件名插入数据库
						FileList fileList2 = new FileList();
						fileList2.setFilefolder(upIdTwo);
						fileList2.setFilename(nowFileName);
						num = fileListService.insert(fileList2);
						log.info("把文件信息插入数据库,num不为0即插入成功:" + num);
					} else {
						log.info("上传失败了。。。");
						return "uploadTwo";
					}
				} else {
					// 遍历folder表中id对应fileList的fileFolder，然后获得fileName，判断跟要上传的文件名是否相等
					for (FileList fileList : fileListName) {
						if (fileList.getFilename().equals(nowFileName)) {
							// 解决方法① 改要上传的文件名字 ②不上传这个文件
							// 弹回那个页面，if test，报错信息存在的话就显示 一个输入框，让用户
							// 输入新的文件名，在新的Controller执行？还是在这里？
							log.info("文件名相等，不能直接上传！");
							break;
						} else {
							// 可以上传
							String lastUploadPath = uploadPath + nowFileName;
							flag = uplocal(file1, lastUploadPath);
							if (flag) {
								log.info("上传成功了。。。");
								// 把文件名插入数据库
								FileList fileList2 = new FileList();
								fileList2.setFilefolder(upIdTwo);
								fileList2.setFilename(nowFileName);
								num = fileListService.insert(fileList2);
								log.info("把文件信息插入数据库,num不为0即插入成功:" + num);
							} else {
								log.info("上传失败了。。。");
								return "upload";
							}
						}
					}
				}
			}

			if (flag) {

				// 获得全部的文件夹，在页面中显示
				List<Folder> lFolders = folderService.selectAll();

				request.getSession().setAttribute("lFolders", lFolders);
				return "allFolder";
			} else {
				request.getSession().setAttribute("uploadTwoErr", "该文件名已经存在，请重新命名上传！");
				log.info("文件上传失败了。。。");
				return "uploadTwo";
			}
		}
	}

	// 上传文件的代码
	public boolean uplocal(MultipartFile file, String filePath) {
		
		File desFile = new File(filePath);
		if (!desFile.getParentFile().exists()) {
			desFile.mkdirs();
		}
		try {
			file.transferTo(desFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
}
