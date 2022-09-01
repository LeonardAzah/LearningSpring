package main.hibernte.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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
			int theId =1;
			// start a transcation
			session.beginTransaction();
			
			//HQL
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id=:theInstructorId "
					, Instructor.class);
			
			//set parameter on query
			query.setParameter("theInstructorId",theId);
			
			//execute query and get instructor
			Instructor theInstructor =query.getSingleResult();
			
			System.out.println("luv2code: Instructor: " +theInstructor);
			

			
			
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
