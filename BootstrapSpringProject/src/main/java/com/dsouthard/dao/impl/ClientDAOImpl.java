package com.dsouthard.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsouthard.dao.ClientDAO;
import com.dsouthard.model.ClientDB;

/**
 * Implementation of Client DAO
 *
 * @author D. Southard
 *
 */
@Repository("ClientDAO")
@SuppressWarnings("unchecked")
public class ClientDAOImpl implements ClientDAO {

	@Autowired
	private SessionFactory sessionFactory;


	public boolean deleteClient(final ClientDB clientDB) {

		sessionFactory.getCurrentSession().beginTransaction();

		sessionFactory.getCurrentSession().delete(clientDB);

		return true;
	}


	public boolean deleteClientsByNumber(final ArrayList<BigDecimal> cliNumbers){

		final Query query = sessionFactory.getCurrentSession().getNamedQuery("clientDB.deleteClientsByNumber");

		if( cliNumbers != null ){
			query.setParameterList("cliNumbers", cliNumbers);

			final int cont = query.executeUpdate();

			return true;
		} else
			return false;
	}

	public List<ClientDB> getAllClients() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClientDB.class);
		return criteria.list();
	}

	public List<ClientDB> getClientByName(final String name) {

		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClientDB.class);

		criteria.add(Restrictions.eq("cliName", name));

		return criteria.list();
	}

	public boolean insertClient(final ClientDB clientDB) {

		sessionFactory.getCurrentSession().beginTransaction();

		sessionFactory.getCurrentSession().save(clientDB);

		return true;
	}

	public boolean updateClient(final ClientDB clientDB) {

		sessionFactory.getCurrentSession().beginTransaction();

		sessionFactory.getCurrentSession().update(clientDB);

		return true;
	}

}
