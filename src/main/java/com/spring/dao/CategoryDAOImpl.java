package com.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CategoryDAO;
import com.spring.model.Category;


@SuppressWarnings("deprecation")
@Repository("categoryDAO")

public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	
	}

	@Transactional
	public boolean addCategory(Category category) 
	{
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.save(category);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public List<Category> retrieveCategory() 
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("from Category");
		@SuppressWarnings("unchecked")
		List<Category> listCategory=query.list();
		session.close();
		return listCategory;
	}

	@Transactional
	public boolean deleteCategory(Category category) 
	{	
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.delete(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);	
		return false;
		}
	}

	public Category getCategory(int catId) 
	{
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,catId);
		session.close();
		return category;
	}

	@Transactional
	public boolean updateCategory(Category category) 
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}
	
}