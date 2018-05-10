package com.struts.fileUpload;

import java.io.File;

import javax.servlet.ServletContext;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.apache.commons.io.FileUtils;

public class FileUpload extends ActionSupport implements ServletContextAware{
	/**
	* 
	* 
	*/
	private static final long serialVersionUID = 1L;

	private File userImage;
	private String userImageContentType;
	private String userImageFileName;
	public String execute() {
		try {
			String imgpath=ServletActionContext.getServletContext()+"/sample/userimage"+userImageFileName;
			String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("userimages");

			System.out.println("Image Location:" + filePath);// see the server console for actual location
			FileDTO dto=new FileDTO();
			dto.setLoc(imgpath);
//			File fileToCreate = new File(filePath, userImageFileName);
//			FileUtils.copyFile(userImage, fileToCreate);// copying source file to new file
			new FileDAO().save(dto);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}

}
