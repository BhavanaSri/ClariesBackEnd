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
	@override
	public boolean addCategory(Category category) 
	{
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
		return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		return false;
		}
	}
	@Transactional
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
	    public Category deleteCategory(int category_id) 
	    {   
	    Category CategoryToDelete = new Category();
			CategoryToDelete.setCatId(category_id);
			sessionFactory.getCurrentSession().delete(CategoryToDelete);
			return CategoryToDelete;
			
	    }
	 @Transactional
		@override

	public Category getCategory(int catId) 
	 {
			String hql = "from"+" Category"+" where id=" + catId;
			@SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Category> listCategory = (List<Category>) query.list();
			
			if (listCategory != null && !listCategory.isEmpty()) {
				return listCategory.get(0);
			}
			return null;
	 }

	@Transactional
	@override
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

	public Category deleteCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}