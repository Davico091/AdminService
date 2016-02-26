package com.example.admin.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.service.bean.Product;
import com.example.admin.service.dao.ProductDAO;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public int saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.saveProduct(product);
	}

	@Override
	public int editProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.editProduct(product);
	}

	@Override
	public Product getProductById(Product product) {
		// TODO Auto-generated method stub
		return productDAO.getProductById(product);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDAO.getProducts();
	}

	@Override
	public int deleteProduct(int codigo_producto) {
		// TODO Auto-generated method stub
		return productDAO.deleteProduct(codigo_producto);
	}

}
