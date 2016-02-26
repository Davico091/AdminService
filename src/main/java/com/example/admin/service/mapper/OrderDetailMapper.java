package com.example.admin.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.example.admin.service.bean.OrderDetail;

public class OrderDetailMapper implements RowMapper {



	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderDetail detail = new OrderDetail();
	
		detail.setCodigo_pedido(rs.getInt(1));
		detail.setCodigo_producto(rs.getInt(2));
		detail.setCantidad(rs.getInt(3));
		return detail;
	}

}
