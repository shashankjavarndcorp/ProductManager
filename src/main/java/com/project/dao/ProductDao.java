package com.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.project.model.Product;



public interface ProductDao {
	void save(Product p) throws SQLException;

	public Product getProductById(int id) throws SQLException;
	
	void update(Product p) throws SQLException;

	void delete(Integer productId) throws SQLException;
	
	public List<Product> getAllProducts() throws SQLException;
}
