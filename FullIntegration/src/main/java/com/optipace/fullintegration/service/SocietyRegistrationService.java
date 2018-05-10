package com.optipace.fullintegration.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optipace.fullintegration.controller.SocietyController;
import com.optipace.fullintegration.dao.SocietyRegistrationDAO;
import com.optipace.fullintegration.dto.SocietyRegistrationDTO;

@Service
public class SocietyRegistrationService {

	@Autowired
	private SocietyRegistrationDAO dao;
	
	public static final Logger LOGGER = Logger.getLogger(SocietyController.class);
	
	public SocietyRegistrationService() {
		LOGGER.debug(this.getClass().getSimpleName() + "\t created...");
	}
	
	public void saveForm(SocietyRegistrationDTO dto)
	{
		LOGGER.debug("inside service");
		dao.saveForm(dto);
		
	}
}
