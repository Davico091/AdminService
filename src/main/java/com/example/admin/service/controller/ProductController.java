package com.example.admin.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.service.bean.Product;
import com.example.admin.service.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	IProductService iProductService;
	
	@RequestMapping(value="/product/save",method=RequestMethod.POST)
	public ResponseEntity saveProduct(@RequestBody Product product){
		int result = iProductService.saveProduct(product);
		if(result>0){
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else
		{
			return new ResponseEntity<>(result, HttpStatus.METHOD_FAILURE);
		}
		
	}
	@RequestMapping(value="/product/edit",method=RequestMethod.POST)
	public ResponseEntity editProduct(@RequestBody Product product){
		int result = 0;
		result = iProductService.editProduct(product);
		if(result>0){
			return new ResponseEntity<>(result,HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(result,HttpStatus.EXPECTATION_FAILED);
		}
	}
	@RequestMapping(value="/product/get",method=RequestMethod.POST)
	public ResponseEntity getProduct(@RequestBody Product product){
		Product productResult= iProductService.getProductById(product) ; 
		
		if(productResult!=null){
			return new ResponseEntity<>(productResult,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>("No se encontraron resultados.",HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	@RequestMapping(value="/product/list",method=RequestMethod.POST)
	public ResponseEntity getProducts() {
		
		List<Product> products = iProductService.getProducts();
		if(products.size()>0){
			return new ResponseEntity<>(products,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>("No se encontraron resultados.",HttpStatus.EXPECTATION_FAILED);
		}
	}
	@RequestMapping(value="/product/delete",method=RequestMethod.POST)
	public ResponseEntity deleteProduct(@RequestBody int codigo_producto) {
		int result =0;
		result = iProductService.deleteProduct(codigo_producto);
		
		if(result>0){
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>("No se pudo efectuar la operacion.",HttpStatus.EXPECTATION_FAILED);
		}
		
	}
}
