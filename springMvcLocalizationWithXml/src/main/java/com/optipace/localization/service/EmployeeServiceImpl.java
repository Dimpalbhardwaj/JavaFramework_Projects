package com.optipace.localization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optipace.localization.dao.EmployeeDAO;
import com.optipace.localization.dto.EmployeeDTO;
@Service
public class EmployeeServiceImpl implements EmployeeService {


		@Autowired
	    EmployeeDAO dao;
	     
	    public List<EmployeeDTO> getAllEmployees()
	    {
	        return dao.getAllEmployees();
	    }

}
