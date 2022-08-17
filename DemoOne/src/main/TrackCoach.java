package main;

import main.fortuneservice.FortuneService;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Runa hard 5K";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "just do it" +fortuneService.grtFortune();
	}

	//add an init method
	public void doMyStartupStuff() {
		System.out.println("TracCoach: inside method do my startup stuff");
	}
	
	//add a destroy method
	public void doMyMethodDestroyStuff() {
		System.out.println("TrackCoach: inside method do my mthod destroy stuff");
	}
	
	
	
	
	
	
	
}
