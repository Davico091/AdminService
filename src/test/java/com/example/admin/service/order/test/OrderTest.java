package com.example.admin.service.order.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
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

import com.example.admin.service.bean.Order;
import com.example.admin.service.bean.OrderDetail;
import com.example.admin.service.configuration.ApplicationConfiguration;
import com.example.admin.service.service.IOrderService;
import com.example.admin.service.util.Util;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,classes = {ApplicationConfiguration.class})
@WebAppConfiguration
public class OrderTest {

	@Autowired
	IOrderService iOrderService;
	Order order;
	OrderDetail orderDetail;
	List<OrderDetail> details;
	@Before
	public void setUp() throws Exception {
		order = new Order();
		order.setCodigo_cliente(2);
		order.setFecha_pedido("02/08/1991");
		
		details = new ArrayList<OrderDetail>();
		
		OrderDetail detail = new OrderDetail();
		detail.setCodigo_producto(1);
		detail.setCantidad(2);
		details.add(detail);
		detail= new OrderDetail();
		detail.setCodigo_producto(2);
		detail.setCantidad(5);
		details.add(detail);
		
		order.setDetails(details);
		
	}
	@Ignore
	@Test
	public void shouldSaveOrder() {
		assertTrue(iOrderService.saveOrder(order)>0);
	}
	@Ignore
	@Test
	public void shouldGetOrderById(){
		order.setCodigo_pedido(1);
		
		assertNotNull(iOrderService.getOrderById(order.getCodigo_pedido()));
	}

}
