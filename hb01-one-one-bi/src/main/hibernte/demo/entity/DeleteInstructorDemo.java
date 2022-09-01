package main.hibernte.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

public class DeleteInstructorDemo {

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
			
			int theId =4;
			//get the instructor detail object
			InstructorDetail inst = session.get(InstructorDetail.class, theId);
			//print the instructor detail
			System.out.println("\n" +inst);
			
			//print the associated instructor
			System.out.println("\n"+inst.getInstructor());
			
			//delete instructor
			System.out.println("Deleting instructor\n" +inst);
			
			//break he link between instructors
			inst.getInstructor().setInstructorDetail(null);
			session.delete(inst);
			//commit transaction
			System.out.println("Done");
			session.getTransaction().commit();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			//handle connection leak issue
			
			session.close();
			factory.close();
			
		}

	}

}
