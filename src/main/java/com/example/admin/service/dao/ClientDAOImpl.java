package com.example.admin.service.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.admin.service.bean.Client;
import com.example.admin.service.mapper.ClientMapper;

@Repository
public class ClientDAOImpl implements ClientDAO{

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(@Qualifier("dataSourceOrigen")DataSource dataSource){
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}

	@Override
	public int saveClient(Client client) {
		int result =0;
		String query = "INSERT INTO cliente (razon_social,"
										   + "nro_documento,"
										   + "web,"
										   + "direccion,"
										   + "telefono,"
										   + "correo,"
										   + "celular) "
										   + "VALUES ("
										   + "?,?,?,?,?,?,?)";
		
		Object[] params = new Object[]{client.getRazon_social(),
									   client.getNro_documento(),
									   client.getWeb(),
									   client.getDireccion(),
									   client.getTelefono(),
									   client.getCorreo(),
									   client.getCelular()};
		
		result = jdbcTemplate.update(query,params);
		
		return result;
	}

	@Override
	public int editClient(Client client) {
		int result =0;
		String  query = "UPDATE cliente set razon_social=?,"
										 + "nro_documento=?,"
										 + "web=?,"
										 + "direccion=?,"
										 + "telefono=?,"
										 + "correo=?,"
										 + "celular=?"
										 + "WHERE codigo_cliente=?";
		
		Object[] params = new Object[]{client.getRazon_social(),
									   client.getNro_documento(),
									   client.getWeb(),
									   client.getDireccion(),
									   client.getTelefono(),
									   client.getCorreo(),
									   client.getCelular(),
									   client.getCodigo_cliente()};
		
		result = jdbcTemplate.update(query,params);
		
		return result;
	}

	@Override
	public Client getClientById(int codigo_cliente) {
		
		String query ="SELECT * FROM cliente WHERE codigo_cliente = '"+codigo_cliente+"'";
		
		Client client = jdbcTemplate.queryForObject(query, new ClientMapper());
		
		return client;
	}

	@Override
	public int deleteClient(int codigo_cliente) {
		
		int result =0;
		String query = "DELETE FROM cliente WHERE codigo_cliente='"+codigo_cliente+"'";
		
		result = jdbcTemplate.update(query);
		
		return result;
	}

	@Override
	public List<Client> getClients() {
		String query = "SELECT * FROM cliente";
		List<Client> clientes = jdbcTemplate.query(query, new ClientMapper());
		return clientes;
	}
	
}
