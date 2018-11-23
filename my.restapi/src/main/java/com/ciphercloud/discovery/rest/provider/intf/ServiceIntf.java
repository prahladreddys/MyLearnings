/**
 * 
 */
package com.ciphercloud.discovery.rest.provider.intf;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author CipherCloud
 *
 */
@Path("/service")
public interface ServiceIntf {
	
	@Path("/welcome")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getDetailsByName(@QueryParam("name") String name) throws JSONException;	
	
	@Path("/test")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getTest() throws JSONException;
	

}
