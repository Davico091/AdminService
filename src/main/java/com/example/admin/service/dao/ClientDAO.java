package com.example.admin.service.dao;

import java.util.List;

import com.example.admin.service.bean.Client;

public interface ClientDAO {

	int saveClient(Client client);

	int editClient(Client client);

	Client getClientById(int codigo_cliente);

	int deleteClient(int codigo_cliente);

	List<Client> getClients();

}
