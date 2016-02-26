package com.example.admin.service.service;

import java.util.List;

import com.example.admin.service.bean.Client;

public interface IClientService {

	int saveClient(Client client);

	int editClient(Client client);

	Client getClientById(int codigo_cliente);

	int deleteClient(int codigo_cliente);

	List<Client> getClients();

}
