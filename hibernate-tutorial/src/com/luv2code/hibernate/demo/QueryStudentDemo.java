package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory ( once in the project)
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		
		Session session = factory.getCurrentSession();
		
		try{
			// start a transaction
			session.beginTransaction();
			
			// query students
		List<Student> theStudents = session.createQuery("from Student").list();	
			// dispaly students
		System.out.println();
		displayStudents(theStudents);
		
		
		
		// query students lastName= 'Wolowitz'
		theStudents = session.createQuery("from Student s where s.lastName='Wolowitz'").getResultList();
		System.out.println();
		displayStudents(theStudents);
		
		
		// query students: lastName = 'Wolowitz' OR firstName = 'Raj'
		theStudents = session.createQuery("from Student s where s.lastName='Wolowitz' OR s.firstName='Raj'").getResultList();
		System.out.println();
		displayStudents(theStudents);
		
		// query students: firstName ends with 'd'
		System.out.println();
		theStudents = session.createQuery("from Student s where s.firstName LIKE '%d'").getResultList();
		displayStudents(theStudents);
		
		
		
		
		
		
		
		
		
		
		
		
		// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done ! ");
			
		}finally{
			factory.close();
		}
		
		}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

}
