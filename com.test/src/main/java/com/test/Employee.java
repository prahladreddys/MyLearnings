package com.test;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
	int id;
	int age;
	int salary;
	String name;
	public Employee(int id,int age,int salary,String name){
		this.id = id;
		this.age = age;
		this.salary = salary;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" +
                this.salary + "]";
    }
	@Override
	public int compareTo(Employee o) {
		return (this.id - o.id);
	}
	public static Comparator<Employee> salaryComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			return (o1.salary - o2.salary);
		}
		
	};
	
	public static Comparator<Employee> nameComparator = new Comparator<Employee>(){

		@Override
		public int compare(Employee o1, Employee o2) {
			
			return o1.name.compareTo(o2.name);
		}
		
	};
	
	public static Comparator<Employee> idAndName = new Comparator<Employee>(){

		@Override
		public int compare(Employee o1, Employee o2) {
			int flag = o1.id - o2.id;
			if(flag == 0 ) flag = o1.getName().compareTo(o2.getName());
			return flag;
		}
		
	};
}
