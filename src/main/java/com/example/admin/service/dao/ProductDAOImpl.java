package com.example.admin.service.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.admin.service.bean.Product;
import com.example.admin.service.mapper.ProductMapper;

@Repository
public class ProductDAOImpl implements ProductDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(@Qualifier("dataSourceOrigen")DataSource dataSource){
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public int saveProduct(Product product) {
		
		String query = "INSERT INTO producto (descripcion,precio)"
				+ "VALUES(?,?)";
		
		Object[] params = new Object[]{product.getDescripcion(),product.getPrecio()};
		
		int result = jdbcTemplate.update(query,params);
		return result;

	}


	@Override
	public int editProduct(Product product) {
		String query = "UPDATE producto set descripcion=?,precio=?"
					+ " WHERE codigo_producto=?";
		Object[] params = new Object[]{product.getDescripcion(),product.getPrecio(),product.getCodigo_producto()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}


	@Override
	public Product getProductById(Product product) {
		
		String query = "SELECT * FROM producto where codigo_producto='"+product.getCodigo_producto()+"'";
		
		Product obtainProduct = (Product)jdbcTemplate.queryForObject(query, new ProductMapper());
		
		return obtainProduct;
	}


	@Override
	public List<Product> getProducts() {
		
		String query = "SELECT * FROM producto";
		
		List<Product> productos = jdbcTemplate.query(query,new ProductMapper());
		
		return productos;
	}


	@Override
	public int deleteProduct(int codigo_producto) {
		String query ="DELETE FROM producto WHERE codigo_producto='"+codigo_producto+"'";
		int result = jdbcTemplate.update(query);
		return result;
	}

}
