package com.prahlad;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import javax.net.ssl.HttpsURLConnection;

import java.net.*;
import com.google.gson.*;
    

public class Solution {
    /*
     * Complete the function below.
     */
    static void openAndClosePrices(String firstDate, String lastDate, String weekDay)  {
    	try{
    		String[] array = new String[1];
            StringBuilder sb= new StringBuilder();
            sb.append("https://jsonmock.hackerrank.com/api/stocks/?key=");
            sb.append(weekDay);
            sb.append("&page=1");
            String s = sb.toString();
            URL url = new URL(s);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setRequestMethod("GET");
            int resCode = connect.getResponseCode();
    		
            if(resCode == 200){	
               BufferedReader br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                String line;
    			
                while((line=br.readLine())!=null){	
                    JsonObject json = new Gson().fromJson(line, JsonObject.class);
                    JsonArray jarray = json.getAsJsonArray("data");
    				for(int j=0;j<jarray.size();j++) {
    					json = jarray.get(j).getAsJsonObject();
    					System.out.println(json.get("date").toString().replaceAll("\"", "")+" "+json.get("open")+" "+json.get("close"));
    				}
    				Arrays.sort(array);
                } 
        	
            }
    	} catch (IOException e){
    		
    	}
    	
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String _firstDate;
        try {
            _firstDate = in.nextLine();
        } catch (Exception e) {
            _firstDate = null;
        }
        
        String _lastDate;
        try {
            _lastDate = in.nextLine();
        } catch (Exception e) {
            _lastDate = null;
        }
        
        String _weekDay;
        try {
            _weekDay = in.nextLine();
        } catch (Exception e) {
            _weekDay = null;
        }
        
        openAndClosePrices(_firstDate, _lastDate, _weekDay);
        
    }
}
