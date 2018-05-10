package com.optipace.fullintegration.dao;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.optipace.fullintegration.controller.SocietyController;
import com.optipace.fullintegration.dto.SocietyRegistrationDTO;
@Repository

public class SocietyRegistrationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public static final Logger LOGGER = Logger.getLogger(SocietyController.class);

	public SocietyRegistrationDAO() {
		LOGGER.debug(this.getClass().getSimpleName() + "\t created...");
	}
	
	@Transactional
	public void saveForm(SocietyRegistrationDTO dto)
	{
		LOGGER.debug("inside save method dao");
		Session session=sessionFactory.getCurrentSession();
		session.save(dto);
		
	}
}
