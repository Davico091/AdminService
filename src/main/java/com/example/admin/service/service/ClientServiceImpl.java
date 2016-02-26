package com.example.admin.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.service.bean.Client;
import com.example.admin.service.dao.ClientDAO;

@Service
public class ClientServiceImpl implements IClientService{

	@Autowired
	ClientDAO clientDAO;

	@Override
	public int saveClient(Client client) {
		return clientDAO.saveClient(client);
	}

	@Override
	public int editClient(Client client) {
		// TODO Auto-generated method stub
		return clientDAO.editClient(client);
	}

	@Override
	public Client getClientById(int codigo_cliente) {
		
		return clientDAO.getClientById(codigo_cliente);
	}

	@Override
	public int deleteClient(int codigo_cliente) {
		// TODO Auto-generated method stub
		return clientDAO.deleteClient(codigo_cliente);
	}

	@Override
	public List<Client> getClients() {
		// TODO Auto-generated method stub
		return clientDAO.getClients();
	}
	
}
