package com.optipace.fullintegration.dto;

import java.io.Serializable;

import javax.persistence.*;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="society")
public class SocietyRegistrationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(SocietyRegistrationDTO.class);
	@Id
	@GenericGenerator(name="soc_id", strategy="increment")
	@GeneratedValue(generator="soc_id")
	@Column(name="id")
	private int id;
	@Column(name="soc_name")
	private String userName;
	@Column(name="password")
	private String password;
	
	public SocietyRegistrationDTO() {
		LOGGER.debug(this.getClass().getSimpleName() + "\t created...");
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getUserName() {
		return userName;
	}

	public final void setUserName(String userName) {
		this.userName = userName;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
