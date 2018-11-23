package com.ciphercloud.discovery.kb.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.ws.rs.core.Application;


import com.ciphercloud.discovery.rest.provider.impl.ServiceImpl;

public class Service extends Application {

	private Set<Object> svc_singletons = new HashSet<Object>();	
	private Set<Class<?>> svc_classes  = new HashSet<Class<?>>();

	public Service() {
		svc_singletons.add(ServiceImpl.getInstance());
		
		
	}
	

	@Override
	public Set<Object> getSingletons() {
		return svc_singletons;
	}
 
	@Override
	public Set<Class<?>> getClasses() {
		return svc_classes;
	}
	/*
	 * Stub to update globals from the property file
	 */
	private void  UpdateGlobals() 
	{
		//override the global settings from the property file
		
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("/config.properties"));
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
        
	}
	
}


