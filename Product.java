package com.quickart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product {
	@Id
	@Column(name="PRODUCTID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId ;
	@Column(name="PRODUCTNAME")
	private String productName;
	@Column(name="PRODUCTCATEGORY")
	private String productCategory ;
	@Column(name="PRICE")
	private float price ;
	
	public Product(int productId, String productName, String productCategory, float price) {
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.price = price;
	}
	
	public Product() {
		
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}	
}
