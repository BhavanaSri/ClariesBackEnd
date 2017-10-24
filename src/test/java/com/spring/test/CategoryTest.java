package com.spring.test;
 
import static org.junit.Assert.*;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.dao.CategoryDAO;
import com.spring.model.Category;
@Ignore
public class CategoryTest 
{
	
    static CategoryDAO categoryDAO;
     @Ignore
    @BeforeClass
    public static void initialize()
    {
        AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
        configApplnContext.scan("com.niit");
        configApplnContext.refresh();
         
        //SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
         
        categoryDAO=(CategoryDAO)configApplnContext.getBean("categoryDAO");
    }
     
  @Ignore
    @Test
    public void addCategoryTest()
    {
        Category category=new Category();
        category.setCatId(1041);
        category.setCatName("Desktop");
        category.setCatDesc("all kinds of desktops ");
         
        assertTrue(categoryDAO.addCategory(category));
    }
     
    @Ignore
    @Test
    public void updateCategoryTest()
    {
        Category category=new Category();
        category.setCatId(1041);
        category.setCatName("JMShirt");
        category.setCatDesc("John Miller Shirt with Best Price");
         
        assertTrue(categoryDAO.updateCategory(category));
    }
   
  /*  @Ignore
    @Test
    public void deleteCategoryTest()
    {
        Category category=new Category();
        category.setCatId(1041);
        assertTrue(categoryDAO.deleteCategory(category));
    }*/
   
  @Ignore  
   @Test
    public void retrieveCategoryTest()
    {
        List<Category> listCategory=categoryDAO.retrieveCategory();
        assertNotNull("Problem in Retriving ",listCategory);
        this.show(listCategory);
    }
    @Ignore
    public void show(List<Category> listCategory)
    {
        for(Category category:listCategory)
        {
            System.out.println("Category ID:"+category.getCatId());
            System.out.println("Category Name:"+category.getCatName());
        }
    }
 
    @Ignore
    @Test
    public void getCategoryTest()
    {
        Category category=categoryDAO.getCategory(102);
        System.out.println(category.toString());
        assertNotNull("Problem in Getting:",category);
        System.out.println("Category ID:"+category.getCatId());
        System.out.println("Category Name:"+category.getCatName());
        System.out.println("Category Description  = "+category.getCatDesc());
    }
 
}