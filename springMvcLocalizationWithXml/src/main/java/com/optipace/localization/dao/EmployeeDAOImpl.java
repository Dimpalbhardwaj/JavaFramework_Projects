package com.optipace.localization.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.optipace.localization.dto.EmployeeDTO;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	 public List<EmployeeDTO> getAllEmployees()
	    {
	        List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
	         
	        EmployeeDTO vo1 = new EmployeeDTO();
	        vo1.setId(1);
	        vo1.setFirstName("Lokesh");
	        vo1.setLastName("Gupta");
	        employees.add(vo1);
	         
	        EmployeeDTO vo2 = new EmployeeDTO();
	        vo2.setId(2);
	        vo2.setFirstName("Raj");
	        vo2.setLastName("Kishore");
	        employees.add(vo2);
	         
	        return employees;
	    }

}
