package com.optipace.javaConfig.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.optipace.javaConfig.dto.UserDTO;

@Repository

public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + "\t created...");
	}

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<UserDTO> list() {
		@SuppressWarnings("unchecked")
		List<UserDTO> listUser = (List<UserDTO>) sessionFactory.getCurrentSession().createCriteria(UserDTO.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		System.out.println(listUser);
		return listUser;
	}
	@Transactional
	public void saveOrUpdate(UserDTO dto) {
		sessionFactory.getCurrentSession().saveOrUpdate(dto);
	}
	@Transactional
	public void delete(int id) {
		UserDTO userToDelete = new UserDTO();
		userToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}
	@Transactional
	public UserDTO get(int id) {
		String hql = "from UserDTO where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<UserDTO> listUser = (List<UserDTO>) query.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}

		return null;
	}

}
