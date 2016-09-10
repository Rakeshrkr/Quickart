package com.quickart.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quickart.dao.*;
import com.quickart.model.Product;
@Transactional
@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private SessionFactory session ;
	public void addProduct(Product product) {
		session.getCurrentSession().save(product);	
	}
	public void editProduct(Product product) {
		session.getCurrentSession().update(product);	
	}
	public void deleteProduct(int productId) {
		session.getCurrentSession().delete(getProduct(productId));	
	}
	public Product getProduct(int productId) {
		return session.getCurrentSession().get(Product.class,productId);
	}
	public List<Product> getAllProduct() {	
		return session.getCurrentSession().createQuery("from Product").list();
	}

}
