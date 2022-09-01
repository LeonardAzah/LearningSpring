package main.hibernte.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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
			
			//create some courses
			Course myCourses =new Course("Sping&Hibernate for Beginners"); 
			Course myCourses2 =new Course("Java for Beginners"); 
			Course myCourses3 =new Course("Air Guitter the altimate guide"); 

			
			//add courses to instructor
			theInstructor.add(myCourses);
			theInstructor.add(myCourses2);
			theInstructor.add(myCourses3);
			
			//save the courses
			session.save(myCourses3);
			session.save(myCourses2);
			session.save(myCourses);
			
			//commit transaction
			System.out.println("Done");
			session.getTransaction().commit();
			
			
		}finally {
			session.close();
			factory.close();
			
		}

	}

}
