package com.optipace.fileUploading.model;

import org.springframework.web.multipart.MultipartFile;

public class FileBucket {
	
	public FileBucket() {
	System.out.println(this.getClass().getSimpleName()+"\t created.....");
	}
	MultipartFile file;

	public final MultipartFile getFile() {
		return file;
	}

	public final void setFile(MultipartFile file) {
		this.file = file;
	}
	

}
