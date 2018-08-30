package com.qa.repository;

public interface CDRepository {

	String getAllCDs();

	String createCD(String CD);

	String updateCD(Long id, String updatedCD);

	String deleteCD(Long id);
	
}
