package com.prahlad.HibernatePlain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class ManageEmployee {
	private static SessionFactory factory;
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("In Main");
		
		// Create configuration instance
		 Configuration configuration = new Configuration();

		 // Pass hibernate configuration file
		 configuration.configure("hibernate.cfg.xml");

		 // Since version 4.x, service registry is being used
		 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
		 applySettings(configuration.getProperties()).build(); 

		 // Create session factory instance
		 factory = configuration.buildSessionFactory(serviceRegistry);
		// XMl Based factory initialization
		//factory = new Configuration().configure().buildSessionFactory();
		//factory = new Configuration().configure("hibernate.cfg.xml").addProperties(properties).buildSessionFactory();
		// Annotation based factory
		//factory = new AnnotationConfiguration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		ManageEmployee me = new ManageEmployee();
		me.addEmployee("prahlad","reddy",100);
		
		me.listEmployees();
		System.out.println("Done");
	}
	private void listEmployees() {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List<Employee> empList = session.createQuery("From Employee").list();
			for(Employee e : empList){
				System.out.println(e.getId()+"\t"+e.getFirstName()+","+e.getLastName()+"\t"+e.getSalary());
			}
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	private void addEmployee(String fname, String lname, int sal) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Employee e = new Employee(fname,lname,sal);
			session.save(e);
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
