package com.optipace.fileUploading.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="file")
public class FileDetail {

	
	@Id
	@GenericGenerator(name="id", strategy="increment")
	@GeneratedValue(generator="id")
	@Column
	private int id;
	private String name;
	private String loc;
	
	public FileDetail() {
	System.out.println(this.getClass().getSimpleName()+"\t createdd...");
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getLoc() {
		return loc;
	}

	public final void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
