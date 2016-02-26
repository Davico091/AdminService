package com.example.admin.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.admin.service.bean.Order;
import com.example.admin.service.bean.OrderDetail;
import com.example.admin.service.mapper.OrderDetailMapper;
import com.example.admin.service.mapper.OrderMapper;
import com.example.admin.service.util.Util;

@Repository
public class OrderDAOImpl implements OrderDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(@Qualifier("dataSourceOrigen")DataSource dataSource){
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	@Override
	public int saveOrder(final Order order) {
		int result = 0;
		final String query="INSERT INTO pedido(codigo_cliente,fecha_pedido)"
							+ "VALUES(?,?)";
		Object[] params = new Object[] {order.getCodigo_cliente(),order.getFecha_pedido()};
		KeyHolder keyHolder = new GeneratedKeyHolder();
		result = jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps =
						con.prepareStatement(query,new String[]{"codigo_pedido"});
				ps.setInt(1, order.getCodigo_cliente());
				ps.setString(2,Util.parseDate(order.getFecha_pedido()));
				return ps;
			}
		},keyHolder);
		
		if(keyHolder.getKey()!=null){
			String query2 = "INSERT INTO detalle_pedido (codigo_pedido,codigo_producto,cantidad)"
					+ " VALUES (?,?,?)";
			
			for(OrderDetail detalle :order.getDetails()){
				Object[] params2 = new Object[]{keyHolder.getKey(),detalle.getCodigo_producto(),detalle.getCantidad()};
				jdbcTemplate.update(query2,params2);
			}
		}
		else
			result =0;
		
		return result;
	}

	@Override
	public Order getOrderById(int codigo_pedido) {
		
		String query = "SELECT * FROM pedido where codigo_pedido='"+codigo_pedido+"'";
		
		Order order = jdbcTemplate.queryForObject(query,new OrderMapper());
		
		if(order!=null){
			String query2 ="SELECT * FROM detalle_pedido where codigo_pedido ='"+order.getCodigo_pedido()+"'";
			List<OrderDetail> details = jdbcTemplate.query(query2, new OrderDetailMapper());
			if(details.size()>0){
				order.setDetails(details);
			}
			
		}
		
		return order;
	}

}
