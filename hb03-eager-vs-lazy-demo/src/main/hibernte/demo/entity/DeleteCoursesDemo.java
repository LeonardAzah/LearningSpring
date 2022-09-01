package main.hibernte.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {

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
			// start a transcation
			session.beginTransaction();
			// get a course
			int coursID =10;
			Course theCourse = session.get(Course.class, coursID);
			
			//delete course
			System.out.println("Delete the course with id 10");
			
			session.delete(theCourse);
			
			
			
			//commit transaction
			System.out.println("Done");
			session.getTransaction().commit();
			
			
		}finally {
			session.close();
			factory.close();
			
		}

	}

}
