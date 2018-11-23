/**
 * 
 */
package com.ciphercloud.discovery.rest.provider.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ciphercloud.discovery.rest.provider.intf.ServiceIntf;

/**
 * @author CipherCloud
 *
 */
@Path("/service")
public class ServiceImpl implements ServiceIntf{
	
	private static ServiceImpl instance = null;
	
	private ServiceImpl(){	
	}
	
	public synchronized static ServiceImpl getInstance() {
		if(instance == null) {
			instance = new ServiceImpl();
		}
		return instance;
	}

	

	@Override
	@Path("/welcome")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public JSONObject getDetailsByName(@QueryParam("name") String name)
			throws JSONException {
		JSONObject json = new JSONObject();
		json.put("SUCCESS :: ", "Welcome To ....."+name);
		return json;
	}

	@Override
	@Path("/test")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public JSONObject getTest() throws JSONException {
		JSONObject json = new JSONObject();
		json.put("TEST :: ", "Testing rest successfull .....");
		return json;
	}

	

}
