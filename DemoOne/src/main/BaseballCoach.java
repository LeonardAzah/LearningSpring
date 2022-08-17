package main;

import main.fortuneservice.FortuneService;

public class BaseballCoach implements Coach{
	//define a private filed for the dependency
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 min on batting";
	}

	@Override
	public String getDailyFortune() {
		// use fortune service to get the daily fortune
		return fortuneService.grtFortune();
	}

}
