package com.example.admin.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.service.bean.Order;
import com.example.admin.service.bean.OrderDetail;
import com.example.admin.service.dao.OrderDAO;

@Service
public class OrderServiceimpl implements IOrderService{
	
	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public int saveOrder(Order order) {
		return orderDAO.saveOrder(order);
	}

	@Override
	public Order getOrderById(int codigo_pedido) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderById(codigo_pedido);
	}

}
