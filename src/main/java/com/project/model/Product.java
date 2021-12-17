package com.project.model;

public class Product {
	private int id;
	private String productName;
	private int price;
	private int quantityInStock;
	private String vendor;
	private int waranty;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public int getWaranty() {
		return waranty;
	}
	public void setWaranty(int waranty) {
		this.waranty = waranty;
	}
	
	public Product(String productName, int price, int quantityInStock, String vendor, int waranty) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.vendor = vendor;
		this.waranty = waranty;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
}
