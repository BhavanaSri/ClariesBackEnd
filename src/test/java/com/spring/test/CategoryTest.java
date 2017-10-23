package com.spring.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.dao.CategoryDAO;
import com.spring.model.Category;




public class CategoryTest 
{
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.spring");
		configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		
		categoryDAO=(CategoryDAO)configApplnContext.getBean("categoryDAO");
	}
	
   @Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCatId(102);
		category.setCatName("Flower Plants");
		category.setCatDesc("all kinds of flower plants ");
		
		assertTrue(categoryDAO.addCategory(category));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=new Category();
		category.setCatId(1002);
		category.setCatName("Tropical Plants");
		category.setCatDesc("The Indian climatic conditions are partial towards tropical plants, favouring them in order to flourish the view. Hence, we all patronize tropical entities when it comes to our gardens with the likes of Ferns, Bougainvillea, Plantain, Rose, Night Jasmine et al dominating the scenic beauty. With Tropical plants now available online, you are privileged to add more of nature’s blessings into your life.");
		
		assertTrue(categoryDAO.updateCategory(category));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=new Category();
		category.setCatId(1002);
		assertTrue(categoryDAO.deleteCategory(category));
	}
	
	@Ignore
	@Test
	public void retrieveCategoryTest()
	{
		List<Category> listCategory=categoryDAO.retrieveCategory();
		assertNotNull("Problem in Retriving ",listCategory);
		this.show(listCategory);
	}
	
	public void show(List<Category> listCategory)
	{
		for(Category category:listCategory)
		{
			System.out.println("Category ID:"+category.getCatId());
			System.out.println("Category Name:"+category.getCatName());
		}
	}
	

	@Test
	public void getCategoryTest()
	{
		Category category=categoryDAO.getCategory(102);
		assertNotNull("Problem in Getting:",category);
		System.out.println("Category ID:"+category.getCatId());
		System.out.println("Category Name:"+category.getCatName());
		System.out.println("Category Description  = "+category.getCatDesc());
	}

}