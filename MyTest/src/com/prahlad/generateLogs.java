package com.prahlad;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class generateLogs {
	private static final String processedLog = "0,%d,%d,%d,,%s,%s,,%s,%s,%s,null";
	private static Map<String,String> values = new HashMap<String, String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate();
	}

	private static void generate() {
		getCloudIDAndURL();
		try(BufferedWriter bw=new BufferedWriter(new FileWriter("D:/spooldir/1.txt"))){
			Set<Entry<String, String>> entries = values.entrySet();
			int i=0;
			for(Entry<String,String> entry : entries){
				if(i == 0)
					bw.write("connection_status,bytes_in,bytes_out,datasize,ipaddrservice,service_id,start_time,method,ipaddrclient,url,userid,proxyname\n");
				bw.write(getLogEntry(entry.getKey(),entry.getValue()));
				bw.newLine();
				i++;
			}
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Map<String, String> getCloudIDAndURL() {
		
		try(InputStream bis = generateLogs.class.getClassLoader().getResourceAsStream("clouds.json")){
			String kbData = org.apache.commons.io.IOUtils.toString(bis);
			JSONObject kbJson = new JSONObject(kbData);
			JSONArray cloudApps = (JSONArray) kbJson.get("cloudApps");
			for (int i = 0; i < 500; i++) {
				JSONArray dataDomains = (JSONArray) ((JSONObject) cloudApps.get(i)).get("dataDomain");
				values.put(((JSONObject)cloudApps.get(i)).getString("cloudID"), dataDomains.getString(0));
			}
			System.out.println(values.size());
			System.out.println(values);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static String getLogEntry(String cloudID, String url) {
		long in = Long.valueOf(getBytes());
		long out = Long.valueOf(getBytes());
		String value = String.format(processedLog, new Object[] {in,out,in+out,cloudID,String.valueOf(generateDate()+"000"),getIp(),url,getUser()});
		return value;
	}
	private static long getBytes() {
	    Random randomGenerator = new Random();
	    return randomGenerator.nextInt(99999999);
	  }

	private static long generateDate() {
		Random random = new Random();
		LocalDate today = LocalDate.now();
		int minDay = (int) LocalDate.of(today.getYear(), today.getMonth(), 01).toEpochDay();
		int maxDay = (int) today.toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
		ZoneId zoneId = ZoneId.systemDefault();
		return randomBirthDate.atStartOfDay(zoneId).toEpochSecond();
	}
	private static String getIp() {
		int second = (int) ((Math.random() * 3.0D + 1.0D) * 60.0D);
		int third = (int) ((Math.random() * 30.0D + 1.0D) * 6.0D);
		int fourth = (int) (Math.random() * 200.0D + 10.0D);
		return new StringBuilder().append("192.").append(second).append(".")
				.append(third).append(".").append(fourth).toString();
	}
	private static String getUser() {
		String name = new StringBuilder().append("User")
					.append(new Random().nextInt(50)).toString();
		return name;
	}
}
