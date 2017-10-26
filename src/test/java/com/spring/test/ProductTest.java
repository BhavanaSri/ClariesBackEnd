package com.spring.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ProductDAO;
import com.spring.model.Product;

public class ProductTest

	{
		
		private static ProductDAO productDAO;
		@SuppressWarnings("resource")
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext ConfigAppLnContext=new AnnotationConfigApplicationContext();
			ConfigAppLnContext.scan("com.");
			ConfigAppLnContext.refresh();
			//SessionFactory sessionFactory=(Conf.getBean(requiredType, args))
			productDAO=(ProductDAO)ConfigAppLnContext.getBean("productDAO");

		}
		@Transactional
		@Test
		public void addProductTest()
		{
			 Product product= new Product();
			 product.setProductId(1003);
			 product.setProductName("sa");
			 product.setProductDesc("this");
			 product.setPrice(2000);
			 product.setStock(25);
			 product.setCatId(1002);
			 product.setSupplierId(1002);
			 assertTrue("problem in insertion",productDAO.addProduct(product));
		}
		
	
	}