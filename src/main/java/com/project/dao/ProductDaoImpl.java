package com.project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.dao.ProductDao;
import com.project.db.DBUtility;
import com.project.model.Product;


public class ProductDaoImpl implements ProductDao {
	DBUtility db = new DBUtility();
	PreparedStatement pst;
	ResultSet rs;

	@Override
	public void save(Product p) throws SQLException {
		String sql = "insert into product(productName,price,quantityInStock,vendor,waranty)values(?,?,?,?,?)";
		pst = db.createPST(sql);
		pst.setString(1, p.getProductName());
		pst.setInt(2, p.getPrice());
		pst.setInt(3,p.getQuantityInStock());
		pst.setString(4, p.getVendor());
		pst.setInt(5, p.getWaranty());
		db.update(pst);
	}

	@Override
	public Product getProductById(int id) throws SQLException {
		String sql = "select * from product where id=?";
		pst = db.createPST(sql);
		pst.setInt(1, id);
		rs = db.query(pst);
		if (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setProductName(rs.getString("productName"));
			p.setPrice(rs.getInt("price"));
			p.setQuantityInStock(rs.getInt("quantityInStock"));
			p.setVendor(rs.getString("vendor"));
			p.setWaranty(rs.getInt("waranty"));
			return p;
		}

		return null;
	}
	
	@Override
	public void update(Product p) throws SQLException {
		String sql = "update product set productName=?,price=?,quantityInStock=?,vendor=?,waranty=? where id=?";
		pst = db.createPST(sql);
		pst.setString(1, p.getProductName());
		pst.setInt(2, p.getPrice());
		pst.setInt(3, p.getQuantityInStock());
		pst.setString(4, p.getVendor());
		pst.setInt(5, p.getWaranty());
		pst.setInt(6, p.getId());
		db.update(pst);

	}

	@Override
	public void delete(Integer productId) throws SQLException {
		String sql = "delete from product where id=?";
		pst = db.createPST(sql);
		pst.setInt(1, productId);
		db.update(pst);
	}
	
	@Override
	public List<Product> getAllProducts() throws SQLException {
		String sql = "select * from product";
		pst = db.createPST(sql);
		rs = db.query(pst);
		List<Product> products = new ArrayList<Product>();
		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setProductName(rs.getString("productName"));
			p.setPrice(rs.getInt("price"));
			p.setQuantityInStock(rs.getInt("quantityInStock"));
			p.setVendor(rs.getString("vendor"));
			p.setWaranty(rs.getInt("waranty"));

			products.add(p);

		}
		return products;
	}
	
}

