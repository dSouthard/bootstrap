package com.dsouthard.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsouthard.dao.ClientDAO;
import com.dsouthard.model.ClientDB;
import com.dsouthard.service.ClientService;

/**
 * 
 * @author D. Southard
 *
 */
@Service("ClientService")
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDao;
	
	public List<ClientDB> getAllClients() {
		return clientDao.getAllClients();
	}

	public List<ClientDB> getClientByName(String name) {
		return clientDao.getClientByName(name);
	}

	public boolean insertClient(ClientDB clientDB) {
		return clientDao.insertClient(clientDB);
	}

	public boolean updateClient(ClientDB clientDB) {
		return clientDao.updateClient(clientDB);
	}

	public boolean deleteClient(ClientDB clientDB) {
		return clientDao.deleteClient(clientDB);
	}

	public boolean deleteClientsByNumber(ArrayList<BigDecimal> cliNumbers){
		return clientDao.deleteClientsByNumber(cliNumbers);
	}
}
