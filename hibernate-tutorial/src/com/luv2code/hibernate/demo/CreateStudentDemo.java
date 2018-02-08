package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			
			String theDateOfBirthSheldon = "31/12/1998";

            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthSheldon);
			
			
			
			
			Student tempStudent = new Student("Sheldon", "Cooper", "shelly@caltech.com", theDateOfBirth);;
			
			
			// start a transaction
			session.beginTransaction();
			
			// save student object
			System.out.println("Saving student");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done ! ");
			
		}finally{
			factory.close();
		}
		
		
		
		
		
	}

}
