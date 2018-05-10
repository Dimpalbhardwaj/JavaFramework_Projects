package com.struts.fileUpload;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FileDAO {
	public void save(FileDTO dto)
	{
		Configuration configuration=new Configuration();
		configuration.configure();
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();
	}
}
