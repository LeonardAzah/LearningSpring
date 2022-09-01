package main.hibernte.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstCoursesDemo {

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
			System.out.println("Instructor\n"+theInstructor);
			//print the courses attributed to the instructor
			System.out.println("The Courses:\n"+theInstructor.getCourses());
			
			
			
			//commit transaction
			System.out.println("Done");
			session.getTransaction().commit();
			
			
		}finally {
			session.close();
			factory.close();
			
		}

	}

}
