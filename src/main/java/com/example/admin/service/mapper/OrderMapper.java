package com.example.admin.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.example.admin.service.bean.Order;

public class OrderMapper implements RowMapper {


	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setCodigo_pedido(rs.getInt(1));
		order.setCodigo_cliente(rs.getInt(2));
		order.setFecha_pedido(rs.getString(3));
		
	return order;
	}

}
