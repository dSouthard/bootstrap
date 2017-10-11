package com.dsouthard.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dsouthard.model.ClientDB;

/**
 * A Client DAO interface and implementation to abstract and encapsulate 
 * all access to the data source. The DAO manages the connection with the 
 * data source to obtain and store data.
 * 
 * @author D. Southard
 */
public interface ClientDAO {

	public List<ClientDB> getAllClients();
	
	public List<ClientDB> getClientByName(String name);
	
	public boolean insertClient(ClientDB clientDB);
	
	public boolean updateClient(ClientDB clientDB);
	
	public boolean deleteClient(ClientDB clientDB);
	
	public boolean deleteClientsByNumber(ArrayList<BigDecimal> cliNumbers);
}
