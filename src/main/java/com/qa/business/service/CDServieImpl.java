package com.qa.business.service;

import javax.inject.Inject;

import com.qa.repository.CDRepository;


public class CDServieImpl implements CDService{
	
	@Inject
	private CDRepository repo;

	public String getAllCDs() {
		return repo.getAllCDs();
	}

	public String addCD(String account) {
		return repo.createCD(account);
	}

	public String updateCD(Long id, String account) {
		return repo.updateCD(id, account);
	}

	public String deleteCD(Long id) {
		return repo.deleteCD(id);
	}

	public void setRepo(CDRepository repo) {
		this.repo = repo;
	}
}
