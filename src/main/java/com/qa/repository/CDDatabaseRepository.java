package com.qa.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.domain.CD;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class CDDatabaseRepository implements CDRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllCDs() {
		Query query = manager.createQuery("Select a FROM CD a");
		Collection<CD> accounts = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(accounts);
	}

	@Transactional(REQUIRED)
	public String createCD(String cd) {
		CD anAccount = util.getObjectForJSON(cd, CD.class);
		manager.persist(anAccount);
		return "{\"message\": \"CD added sucessfully\"}";
	}

	@Transactional(REQUIRED)
	public String updateCD(Long id, String updatedcd) {
		CD updatedAccount = util.getObjectForJSON(updatedcd, CD.class);
		CD accountFromDB = findAccount(id);
		if (updatedcd != null) {
			accountFromDB = updatedAccount;
			manager.merge(accountFromDB);
		}
		return "{\"message\": \"CD sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteCD(Long id) {
		CD accountInDB = findAccount(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "{\"message\": \"CD sucessfully deleted\"}";
	}

	private CD findAccount(Long id) {
		return manager.find(CD.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}