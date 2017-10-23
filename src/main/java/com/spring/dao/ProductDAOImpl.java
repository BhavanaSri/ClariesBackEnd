package com.spring.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ProductDAO;
import com.spring.model.Product;


@SuppressWarnings("deprecation")
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
    SessionFactory sessionFactory;
    
	
    public ProductDAOImpl(SessionFactory sessionFactory) {
this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean addProduct(Product product) {
		
    	try
        {
            sessionFactory.getCurrentSession().save(product);
            return true;
        }
        catch(Exception e)
        {
        return false;
        }
		
	}

	public boolean deleteProduct(Product product) {
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.delete(product);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);	
		return false;
		}

	}
	
	
	public List<Product> retrieveProducts() {

		Session session=sessionFactory.openSession();
		@SuppressWarnings({ "rawtypes" })
		Query query=session.createQuery("from Supplier");
		@SuppressWarnings({ "unchecked" })
		List<Product> listProduct=query.list();
		session.close();
		return listProduct;
	}

	
	public boolean updateProduct(Product product) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public Product getProduct(int productId) {
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
		session.close();
		return product;
	
	
	}

	public boolean addProductTest(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Product> retrieveProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

