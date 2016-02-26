package com.example.admin.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.admin.service.bean.Product;

public class ProductMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product product = new Product();
		product.setCodigo_producto(rs.getInt(1));
		product.setDescripcion(rs.getString(2));
		product.setPrecio(rs.getDouble(3));
		
		return product;
	}

}
