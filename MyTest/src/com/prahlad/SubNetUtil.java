package com.prahlad;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.net.util.SubnetUtils;
import org.apache.commons.net.util.SubnetUtils.SubnetInfo;

public class SubNetUtil {

	public static void main(String[] args) throws UnknownHostException {
		String ipAdd = "10.10.1.15";
		checkIPisinSubnet(ipAdd);
		
//		String ipAdd1 = "192.168.0.10";
//		checkIPisinSubnet(ipAdd1);
//		
//		String ipAdd2 = "10.1.1.10";
//		checkIPisinSubnet(ipAdd2);
	}

	private static void checkIPisinSubnet(String ipAdd) throws UnknownHostException {
		String subNet = "192.118.119.44/30";
//		String add = "10.10.0.0";
//		String mask = "255.255.255.250";
		SubnetUtils util = new SubnetUtils(subNet);
		SubnetInfo info = util.getInfo();
		System.out.println(info.getAddress());
		System.out.printf("Subnet Information for %s:\n", subNet);
        System.out.println("--------------------------------------");
        System.out.printf("IP Address:\t\t\t%s\t[%s]\n", info.getAddress(),
                Integer.toBinaryString(info.asInteger(info.getAddress())));
        System.out.printf("Netmask:\t\t\t%s\t[%s]\n", info.getNetmask(),
                Integer.toBinaryString(info.asInteger(info.getNetmask())));
        System.out.printf("CIDR Representation:\t\t%s\n\n", info.getCidrSignature());

        System.out.printf("Supplied IP Address:\t\t%s\n\n", info.getAddress());

        System.out.printf("Network Address:\t\t%s\t[%s]\n", info.getNetworkAddress(),
                Integer.toBinaryString(info.asInteger(info.getNetworkAddress())));
        System.out.printf("Broadcast Address:\t\t%s\t[%s]\n", info.getBroadcastAddress(),
                Integer.toBinaryString(info.asInteger(info.getBroadcastAddress())));
        System.out.printf("Low Address:\t\t\t%s\t[%s]\n", info.getLowAddress(),
                Integer.toBinaryString(info.asInteger(info.getLowAddress())));
        System.out.printf("High Address:\t\t\t%s\t[%s]\n", info.getHighAddress(),
                Integer.toBinaryString(info.asInteger(info.getHighAddress())));
		System.out.printf("Total usable addresses: \t%d\n", Integer.valueOf(info.getAddressCount()));
        System.out.printf("Address List: %s\n\n", Arrays.toString(info.getAllAddresses()));
		System.out.printf("Total usable addresses: \t%d\n", Integer.valueOf(info.getAddressCount()));
		if(info.isInRange(ipAdd)){
			System.out.println("###########: its in range");
		} else {
			System.out.println("Not in range");
		}
		System.out.println(ipToLong(InetAddress.getByName(info.getLowAddress())));
		System.out.println(ipToLong(InetAddress.getByName(info.getHighAddress())));
		System.out.println(ipToLong(InetAddress.getByName("192.118.119.44")));
		
		System.out.println(info.getLowAddress());
		System.out.println(info.getHighAddress());
//		final String prompt ="Enter an IP address (e.g. 192.168.0.10):";
//        System.out.println(prompt);
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String address = scanner.nextLine();
//            if(info.isInRange(address)){
//    			System.out.println("###########: its in range");
//    		} else {
//    			System.out.println("Not ");
//    		}
//            System.out.println(prompt);
//        }
	}
	/**
	 * 
	 * @param ip
	 * @return
	 */
	public static long ipToLong(InetAddress ip) {
		byte[] octets = ip.getAddress();
		long result = 0;
		for (byte octet : octets) {
			result <<= 8;
			result |= octet & 0xff;
		}
		return result;
	}
}


