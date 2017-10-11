package com.dsouthard.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dsouthard.model.ClientDB;


/**
 * 
 * @author D. Southard 
 */
public interface ClientService {

	public List<ClientDB> getAllClients();
	
	public List<ClientDB> getClientByName(String name);
	
	public boolean insertClient(ClientDB clientDB);
	
	public boolean updateClient(ClientDB clientDB);
	
	public boolean deleteClient(ClientDB clientDB);
	
	public boolean deleteClientsByNumber(ArrayList<BigDecimal> cliNumbers);
}
