package com.qa.integration;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.CDService;
import com.qa.util.JSONUtil;

@Path("/cd")
public class CDEndpoint {
	
	@Inject
	private CDService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllCDs();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String cd) {
		return service.addCD(cd);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String cd) {
		return service.updateCD(id, cd);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return service.deleteCD(id);

	}

	public void setService(CDService service) {	//For TDD
		this.service = service;
	}
	
	
}
