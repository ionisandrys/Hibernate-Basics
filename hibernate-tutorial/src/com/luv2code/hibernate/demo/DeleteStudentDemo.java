package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory ( once in the project)
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		
		Session session = factory.getCurrentSession();
		
		try{
			// use session object to save Java object
			
			int studentId = 1;
			
			// get a new session and start transaction - for each read/update, we have to open a new session and begin a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on id
		System.out.println("\nGetting student with id: "+ studentId);
		
		Student myStudent = session.get(Student.class, studentId);
		
		// delete student with id = 1, defined previously
	//	System.out.println("\nDeleting student: "+ myStudent);
	//	session.delete(myStudent);
		
		System.out.println("Delete student id=4");
		session.createQuery("delete from Student where id=4").executeUpdate();
		
		
		
		
		
		session.getTransaction().commit();
			
				System.out.println("Done ! ");
			
		}finally{
			factory.close();
		}
		
		
		
		
		
	}

}
