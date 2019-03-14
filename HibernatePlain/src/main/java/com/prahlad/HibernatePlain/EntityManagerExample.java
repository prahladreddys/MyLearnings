package com.prahlad.HibernatePlain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerExample {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Starting Transaction");
		entityManager.getTransaction().begin();
		Employee employee = new Employee("ravi","reddy",200);
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		System.out.println("Generated Employee ID = " + employee.getId());
	}

}
