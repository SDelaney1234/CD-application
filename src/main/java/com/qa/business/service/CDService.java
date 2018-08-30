package com.qa.business.service;

public interface CDService {
	
	String getAllCDs();

	String addCD(String cd);

	String updateCD(Long id, String cd);

	String deleteCD(Long id);

}
