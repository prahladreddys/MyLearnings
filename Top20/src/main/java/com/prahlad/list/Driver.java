/**
 * 
 */
package com.prahlad.list;

import java.util.Random;

/**
 * @author Prahlad created on 07-Jun-2017
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testList(new LinkedList());
	}

	private static void testList(List list) {
		Random r = new Random();
		for(int i=0;i<20;i++){
			list.add(r.nextInt(10)+1);
		}
		list.display();
	}

}
