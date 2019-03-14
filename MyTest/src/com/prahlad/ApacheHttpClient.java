package com.prahlad;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ApacheHttpClient {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "https://www.checkmarx.com/";
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		HttpResponse httpResponse = client.execute(request);
		System.out.println(httpResponse.getStatusLine().getStatusCode());
		System.out.println("Done");
	}

}
