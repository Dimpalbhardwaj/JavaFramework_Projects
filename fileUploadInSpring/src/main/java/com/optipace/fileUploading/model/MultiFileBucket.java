package com.optipace.fileUploading.model;

import java.util.ArrayList;
import java.util.List;

public class MultiFileBucket {

	List<FileBucket> files = new ArrayList<FileBucket>();
	 public MultiFileBucket(){
		 System.out.println(this.getClass().getSimpleName()+"\t created......");
	        files.add(new FileBucket());
	        files.add(new FileBucket());
	        files.add(new FileBucket());
	    }
	public final List<FileBucket> getFiles() {
		return files;
	}
	public final void setFiles(List<FileBucket> files) {
		this.files = files;
	}
	 
}
