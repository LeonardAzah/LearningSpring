package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

	public static void main(String[] args) {
		//load the sping config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-application.xml");
		
		//retrieve bean from container
		Coach coach =context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		//check if they are the same bean
		boolean result = (coach == alphaCoach);
		
		//print out the results
		System.out.println("\n Pointing to the same object "+result);
		
		System.out.println("\n Memory location for Coach: "+coach);
		
		System.out.println("\nMemory location for alpha coach: "+alphaCoach+"\n");
		//close the context
		context.close();

	}

}
