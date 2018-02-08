package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) throws ParseException {
		
		// create session factory ( once in the project)
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		
		Session session = factory.getCurrentSession();
		
		try{
			// use session object to save Java object
			
			// create student object
			System.out.println("Creating new student object");
			String theDateOfBirthAmy = "04/01/1991";

            Date theDateOfBirth4 = DateUtils.parseDate(theDateOfBirthAmy);
			Student tempStudent = new Student("Amy", "Fawler", "amy.f@caltech.com", theDateOfBirth4);
			
			
			// start a transaction
			session.beginTransaction();
			
			// save student object
			System.out.println("Saving student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// find out student;s id: primary key
			System.out.println("Saved student. Generated id: "+ tempStudent.getId());
			
		// get a new session and start transaction - for each read/update, we have to open a new session and begin a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on id
		System.out.println("\nGetting student with id: "+ tempStudent.getId());
		
		Student myStudent = session.get(Student.class, tempStudent.getId());
			
		System.out.println("Done: "+ myStudent);
			// commit transaction - commit transaction after each update / read 
			session.getTransaction().commit();
			
			System.out.println("Done ! ");
			
		}finally{
			factory.close();
		}
		
		
		
		
		
	}

}
