package com.spring.dao;
 
import java.util.List;
 
import com.spring.model.Category;
 
public interface CategoryDAO 
{
    public boolean addCategory(Category category);
    public List<Category> retrieveCategory();
    public boolean deleteCategory(Category category);
    public Category getCategory(int catId);
    public boolean updateCategory(Category category);
}