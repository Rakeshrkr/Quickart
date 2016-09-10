package com.quickart.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.quickart.dao.ProductDao;
import com.quickart.model.Product;
import com.quickart.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;
	
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	public void editProduct(Product product) {
		productDao.editProduct(product);	
	}
	
	public void deleteProduct(int productId) {
		productDao.deleteProduct(productId);	
	}
	
	public Product getProduct(int productId) {	
		return productDao.getProduct(productId);
	}
	
	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}
}
