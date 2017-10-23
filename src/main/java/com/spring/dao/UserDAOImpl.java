package com.spring.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.User;


@Repository
public class UserDAOImpl implements UserDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory) {
	
	this.sessionFactory=sessionFactory;
		
	}

	public boolean saveUser(User user) {
		
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(user);
		Transaction tx=session.beginTransaction();
		tx.commit();
		
		
		return true;
	}

}