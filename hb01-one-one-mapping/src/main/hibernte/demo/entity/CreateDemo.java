package main.hibernte.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		try {
			//create he objects
			Instructor instructor = new Instructor("Mbe", "Leonard", "mbe@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://www.gamingme.com/youtube", "football");
			//associate the object
			instructor.setInstructorDetail(instructorDetail);
			// start a transcation
			session.beginTransaction();
			System.out.println("Saving instructor: "+instructor);
			session.save(instructor);
			
			//commit transaction
			System.out.println("Done");
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
			
		}

	}

}
