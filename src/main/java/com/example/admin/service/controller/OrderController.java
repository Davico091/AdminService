package com.example.admin.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.service.bean.Order;
import com.example.admin.service.service.IOrderService;

@RestController
public class OrderController {
	
	@Autowired
	IOrderService iOrderService;
	
	@RequestMapping(value="/order/save",method=RequestMethod.POST)
	public ResponseEntity saveOrder(@RequestBody Order order){
		int result = 0;
		result =iOrderService.saveOrder(order);
		if(result>0)
			return new ResponseEntity<>(result,HttpStatus.OK);
		else
			return new ResponseEntity<>("No se pudo completar la operacion",HttpStatus.EXPECTATION_FAILED);
	}
	
	@RequestMapping(value="/order/get",method=RequestMethod.POST)
	public ResponseEntity getOrderById(@RequestBody int orderCode){
		Order order= iOrderService.getOrderById(orderCode);
		if(order!=null)
			return new ResponseEntity<>(order,HttpStatus.OK);
		else
			return new ResponseEntity<>("No se pudo obtener ningun resultado",HttpStatus.EXPECTATION_FAILED);
	}
	
	

}
