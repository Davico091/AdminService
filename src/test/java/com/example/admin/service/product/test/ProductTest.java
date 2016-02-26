package com.example.admin.service.product.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.admin.service.bean.Product;
import com.example.admin.service.configuration.ApplicationConfiguration;
import com.example.admin.service.service.IProductService;
import com.google.gson.Gson;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,classes = {ApplicationConfiguration.class})
@WebAppConfiguration
public class ProductTest {
	
	@Autowired
	IProductService iProductService;
	Product product;
	@Before
	public void setUp() throws Exception {
		product = new Product();
		
		product.setDescripcion("Pan con palta");
		product.setPrecio(0.6);
	}
	@Ignore
	@Test
	public void shouldSaveProduct() {
		Gson gson = new Gson();
		System.out.println(gson.toJson(product));
		 
		assertTrue(iProductService.saveProduct(product)>0);
	}
	@Ignore
	@Test
	public void shouldEditProduct(){
		product.setCodigo_producto(1);
		assertTrue(iProductService.editProduct(product)>0);
	}
	@Ignore
	@Test
	public void shouldGetProductById(){
		product.setCodigo_producto(1);
		Product dd = iProductService.getProductById(product);
		assertNotNull(iProductService.getProductById(product));
		
	}
	@Ignore
	@Test
	public void shouldGetProducts(){
		List<Product> products = iProductService.getProducts();
		assertTrue(products.size()>0);
	}
	@Ignore
	@Test
	public void shouldDeleteProduct(){
		product.setCodigo_producto(3);
		int result = iProductService.deleteProduct(product.getCodigo_producto());
		assertTrue(result>0);
	}
	
}
