package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Employee[] list = new Employee[4];
//		list[0] = new Employee(10,25,5000,"Mike");
//		list[1] = new Employee(1, 35, 15000, "Jhon");
//		list[2] = new Employee(7,27,10000,"Sara");
//		list[3] = new Employee(15,40,2500,"vid");
		List<Employee> list = new ArrayList<>();
		Employee e1 = new Employee(10,25,5000,"Mike");
		Employee e2 = new Employee(1, 35, 15000, "Jhon");
		Employee e3 = new Employee(7,27,10000,"Sara");
		Employee e4 = new Employee(15,40,2500,"vid");
		list.add(e1);list.add(e2);list.add(e3);list.add(e4);
		
		Collections.sort(list);
		System.out.println(list.toString());
		
		//Salary comparator
//		Arrays.sort(list,Employee.salaryComparator);
//		System.out.println(Arrays.toString(list));
		list.sort(Employee.salaryComparator);
		System.out.println(list.toString());
		
		
		// Age comparator
//		Arrays.sort(list,Employee.nameComparator);
//		System.out.println(Arrays.toString(list));
		
		//Id and Name comparator
//		Arrays.sort(list,Employee.idAndName);
//		System.out.println(Arrays.toString(list));
	}

}
