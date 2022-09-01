package main.hibernte.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

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
			
			// start a transcation
			session.beginTransaction();
			//get instructor by id
			int instId =1;
			
			Instructor instructor = session.get(Instructor.class, instId);
			//delete Instructor
			if(instructor != null) {
			
			session.delete(instructor);
			System.out.println("Instructor deleted");
			}
			//commit transaction
			System.out.println("Done");
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
			
		}

	}

}
