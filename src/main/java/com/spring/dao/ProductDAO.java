package com.spring.dao;


import java.util.List;

import com.spring.model.Product;


public interface ProductDAO 
{
	public boolean addProductTest(Product product);
	public List<Product> retrieveProduct();
	public boolean deleteProduct(Product product);
	public Product getProduct(int productId);
	public boolean updateProduct(Product product);
}