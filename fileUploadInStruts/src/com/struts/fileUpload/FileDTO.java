package com.struts.fileUpload;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "img_table")
public class FileDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "id", strategy = "increment")
	@GeneratedValue(generator = "id")
	@Column(name = "img_id")
	private int id;
	@Column(name = "img_loc")
	private String loc;

	public FileDTO() {
		System.out.println(this.getClass().getSimpleName() + "\t created...");
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
