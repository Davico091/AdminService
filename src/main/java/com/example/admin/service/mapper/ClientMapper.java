package com.example.admin.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.admin.service.bean.Client;

public class ClientMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Client client = new Client();
		client.setCodigo_cliente(rs.getInt(1));
		client.setRazon_social(rs.getString(2));
		client.setNro_documento(rs.getString(3));
		client.setWeb(rs.getString(4));
		client.setDireccion(rs.getString(5));
		client.setTelefono(rs.getString(6));
		client.setCorreo(rs.getString(7));
		client.setCelular(rs.getString(8));
		return client;
	}

}
