package com.usaa.ecag.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.usaa.ecag.gdapi.SendMessage;

@RequestScoped
@Path("/sendmessages")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class SendMessageEndpoint extends SendMessage {
	public SendMessageEndpoint() {
		super("default");
		
	}
	public SendMessageEndpoint(String string) {
		super(string);
		
	}
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the sendmessage 
		SendMessage sendMessage=new SendMessage("Mymessage");
		if (sendMessage == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Gson gson=new Gson();
		String json=gson.toJson(sendMessage);
		System.out.println("SnedMessage is "+json);
		return Response.ok(sendMessage).entity(json).build();
	}

}
