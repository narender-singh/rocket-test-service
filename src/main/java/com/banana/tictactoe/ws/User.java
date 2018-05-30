package com.banana.tictactoe.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class User {

	@GET
	@Path("/get")
	@Produces({MediaType.APPLICATION_JSON })	
	public Response getUsers(){
		return Response.status(Response.Status.OK).entity(new Object(){
			@SuppressWarnings("unused")
			public String user = "Narender-Singh";
			@SuppressWarnings("unused")
			public String testing = "Successful";			
		}).build();
	}
	
}
