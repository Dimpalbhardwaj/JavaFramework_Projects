package com.optipace.javaConfig.dao;

import java.util.List;

import com.optipace.javaConfig.dto.UserDTO;

public interface UserDAO {
	
	public List<UserDTO> list();

	public UserDTO get(int id);

	public void saveOrUpdate(UserDTO user);

	public void delete(int id);

}
