package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		//load the sping config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-application.xml");
		
		//retrieve bean from container
		Coach coach =context.getBean("myCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		context.close();

	}

}
