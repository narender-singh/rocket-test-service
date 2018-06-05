package com.banana.tictactoe.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;
import com.rocket.jdbc.RocketCassandraDbConnectionPool;

@Path("/")
public class User {

	private final RocketCassandraDbConnectionPool cassPool;
	private final Session cassSession;
	
	
	public User(RocketCassandraDbConnectionPool pool)
	{
		cassPool = pool;
		cassSession = cassPool.getsession();
	}
	
	@GET
	@Path("/get")
	@Produces({MediaType.APPLICATION_JSON, MediaType.WILDCARD })	
	public Response getUsers(){
		return Response.status(Response.Status.OK).entity(new Object(){
			@SuppressWarnings("unused")
			public String user = "Narender-Singh";
			@SuppressWarnings("unused")
			public String testing = "Successful";			
		}).build();
	}
	
	
	
	@GET
	@Path("/data")
	@Produces({MediaType.WILDCARD})
	public Response getData(){
		Statement s = new SimpleStatement("SELECT JSON id FROM tuts.data");
		ResultSet res = cassSession.execute(s);
		List<Row> rows = res.all();
		return Response.status(Response.Status.OK).entity(rows.toString()).build();
	}
	
}
