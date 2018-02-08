package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) throws ParseException {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession(); 

		try{
			System.out.println("Creating student objects");
			
			String theDateOfBirthLeonard = "11/02/1991";
			Date theDateOfBirth1 = DateUtils.parseDate(theDateOfBirthLeonard);
			
			String theDateOfBirthHoward = "19/08/1991";
			Date theDateOfBirth2 = DateUtils.parseDate(theDateOfBirthHoward);
			
			String theDateOfBirthRaj = "11/22/1991";
			Date theDateOfBirth3 = DateUtils.parseDate(theDateOfBirthRaj);
			
			
			
			Student tempStudent1 = new Student("Leonard","Hofstadter","leonard@caltech.com",theDateOfBirth1);
			Student tempStudent2 = new Student("Howard","Wolowitz","howard.w@caltech.com",theDateOfBirth2);
			Student tempStudent3 = new Student("Raj","Kootropali","raj.k@caltech.com", theDateOfBirth3);
			
			// start a transaction
			session.beginTransaction();
			
			// save objects
			System.out.println("Saving students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			
		}finally{
			session.close();
		}
		
		
		
	}

}
