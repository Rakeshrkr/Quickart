package com.quickart.controller;
import com.quickart.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quickart.dao.ProductDao;
import com.quickart.model.Product;
import com.quickart.service.ProductService;
@Controller
public class ProductController {
	@Autowired
	private ProductService productService ;	
	@RequestMapping("/productTable")
	public ModelAndView getProducts(Map<String, Object> map){
		Product product = new Product();
		map.put("product", product);
		map.put("productList", productService.getAllProduct());
		ModelAndView modelandview = new ModelAndView("ProductTable");
		return modelandview ;
	}
	@RequestMapping(value="/product.do" , method=RequestMethod.POST)
	public String doActions(@ModelAttribute Product product,BindingResult result,@RequestParam String action,Map<String, Object> map){
		Product productResult = new Product();
		
		if(action.toLowerCase()=="add"){
			productService.addProduct(product);
			productResult = product ;
		}
		else if(action.toLowerCase()=="edit"){
			productService.editProduct(product);
			productResult = product ;	
		}
		else if(action.toLowerCase()=="delete"){
			productService.deleteProduct(product.getProductId());
			productResult = new Product() ;	
		}
		
		else if(action.toLowerCase()=="search"){
			Product searchedProduct = productService.getProduct(product.getProductId());
			productResult = searchedProduct !=null ? searchedProduct : new Product();
		}
		else{
		}
		
		map.put("product", product);
		map.put("productList", productService.getAllProduct());
		return "Product" ;
	}
	
	
	
	
	
	
/*@RequestMapping(value="/ProductTable" ,method=RequestMethod.GET) 
public ModelAndView ProdTab(){
	List<Product> productList = new ArrayList<Product>();
	Product product1 = new Product(101,"Tshirt","Clothing",400);
	Product product2 = new Product(102,"Jeans","Clothing",1400);
	Product product3 = new Product(103,"Dell 5050 ","Electronics",44000);
	Product product4 = new Product(104,"Sofa","Furniture",4000);
	productList.add(product1);
	productList.add(product2);
	productList.add(product3);
	productList.add(product4);
	
	ModelAndView mav = new ModelAndView("ProductTable");
	mav.addObject("productlist", productList);
	return mav;
	}*/
}
