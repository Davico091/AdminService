package com.example.admin.service.dao;

import java.util.List;

import com.example.admin.service.bean.Product;

public interface ProductDAO {

	int saveProduct(Product product);

	int editProduct(Product product);

	Product getProductById(Product product);

	List<Product> getProducts();

	int deleteProduct(int codigo_producto);

}
