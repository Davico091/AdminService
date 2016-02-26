package com.example.admin.service.service;

import java.util.List;

import com.example.admin.service.bean.Order;
import com.example.admin.service.bean.OrderDetail;

public interface IOrderService {

	int saveOrder(Order order);

	Order getOrderById(int codigo_pedido);

}
