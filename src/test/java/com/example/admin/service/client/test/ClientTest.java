package com.example.admin.service.client.test;

import static org.junit.Assert.*;

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

import com.example.admin.service.bean.Client;
import com.example.admin.service.configuration.ApplicationConfiguration;
import com.example.admin.service.service.IClientService;
import com.example.admin.service.util.Util;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,classes = {ApplicationConfiguration.class})
@WebAppConfiguration
public class ClientTest {
	
	@Autowired
	IClientService iClientService;
	Client  client;
	@Before
	public void setUp() throws Exception {
		client = new Client();
		client.setRazon_social("David Perez");
		client.setNro_documento("1046585421");
		client.setWeb("www.david.com");
		client.setDireccion("mz A5 Lot4 Las Vegas Santa anita");
		client.setTelefono("3540502");
		client.setCorreo("correo@dominio.com");
		client.setCelular("954101020");
	}
	@Ignore
	@Test
	public void shouldSaveClient() {
		assertTrue(iClientService.saveClient(client)>0);
	}
	
	@Ignore
	@Test
	public void shouldEditClient(){
		client.setCodigo_cliente(1);
		client.setRazon_social("Jose ss");
		assertTrue(iClientService.editClient(client)>0);
	}
	@Ignore
	@Test
	public void shouldGetClientById(){
		client.setCodigo_cliente(1);
		assertNotNull(iClientService.getClientById(client.getCodigo_cliente()));
	}
	@Ignore
	@Test 
	public void shouldDeleteClient(){
		client.setCodigo_cliente(3);
		assertTrue(iClientService.deleteClient(client.getCodigo_cliente())>0);
	}
	@Ignore
	@Test
	public void shouldGetClients(){
		List<Client> clients = iClientService.getClients();
		assertTrue(clients.size()>0);
	}

}
