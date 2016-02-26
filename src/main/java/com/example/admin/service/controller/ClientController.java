package com.example.admin.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.service.bean.Client;
import com.example.admin.service.service.IClientService;

@RestController
public class ClientController {

	@Autowired
	IClientService iClientService;
	
	@RequestMapping(value="/client/save",method=RequestMethod.POST)
	public ResponseEntity saveClient(@RequestBody Client client){
		
		 int result =iClientService.saveClient(client);
		
		 if(result>0)
			 return new ResponseEntity<>(result,HttpStatus.OK);
		 else
			 return new ResponseEntity<>("No se pudo hacer el registro",HttpStatus.EXPECTATION_FAILED);
	}
	@RequestMapping(value="/client/edit",method=RequestMethod.POST)
	public ResponseEntity editClient(@RequestBody Client client) {
		int result = iClientService.editClient(client);
		 if(result>0)
			 return new ResponseEntity<>(result,HttpStatus.OK);
		 else
			 return new ResponseEntity<>("No se pudo completar la operacion",HttpStatus.EXPECTATION_FAILED);
	}
	@RequestMapping(value="/client/get",method=RequestMethod.POST)
	public ResponseEntity getClient(@RequestBody int codigo_cliente){
		
		Client client =iClientService.getClientById(codigo_cliente);
		if(client!=null)
			return new ResponseEntity<>(client,HttpStatus.OK);	
		else
			return new ResponseEntity<>("No se pudo encontrar ningun registro",HttpStatus.EXPECTATION_FAILED);
	}
	@RequestMapping(value="/client/delete",method=RequestMethod.POST)
	public ResponseEntity deleteClient(@RequestBody int codigo_cliente){
		int result = iClientService.deleteClient(codigo_cliente);
		if(result>0)
			return new ResponseEntity<>(result,HttpStatus.OK);
		else
			return new ResponseEntity<>("No se pudo completar la operacion",HttpStatus.EXPECTATION_FAILED);
	}
	@RequestMapping(value="/client/list",method=RequestMethod.POST)
	public ResponseEntity getClients(){
		List<Client> clients = iClientService.getClients();
		if(clients.size()>0)
			return new ResponseEntity<>(clients,HttpStatus.OK);
		else
			return new ResponseEntity<>("No se encontro ningun resultado",HttpStatus.EXPECTATION_FAILED);
					
	}
	
	
}
