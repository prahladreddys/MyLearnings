package com.prahlad;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Mytest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{\"page\":1,\"per_page\":500,\"total\":2500,\"total_pages\":5,\"data\":[{\"date\":\"5-January-2000\",\"open\":5265.09,\"high\":5464.35,\"low\":5184.48,\"close\":5357},{\"date\":\"6-January-2000\",\"open\":5424.21,\"high\":5489.86,\"low\":5391.33,\"close\":5421.53}]}";
		JsonParser parser = new JsonParser();
		JsonObject obj = (JsonObject) parser.parse(s);
		JsonArray data = (JsonArray) obj.get("data");
		for(int i=0;i<data.size();i++){
			JsonObject o = (JsonObject) data.get(i);
			System.out.println(o.get("date").toString()+" "+o.get("open")+" "+o.get("close"));
		}
	}

}
