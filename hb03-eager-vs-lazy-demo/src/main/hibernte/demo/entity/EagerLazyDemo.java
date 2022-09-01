package main.hibernte.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		try {
			int instId =1;
			// start a transcation
			session.beginTransaction();
			
			//get the instructor from db
			Instructor theInstructor = session.get(Instructor.class, instId);
			
			//print the istructor to console
			System.out.println("luv2code: Instructor\n"+theInstructor);
			//print the courses attributed to the instructor
			
			
			
			//commit transaction
			System.out.println("Done");
			session.getTransaction().commit();
			System.out.println("luv2code: The Courses:\n"+theInstructor.getCourses());
			
			
		}finally {
			session.close();
			factory.close();
			
		}

	}

}