package main;

import main.fortuneservice.FortuneService;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	public CricketCoach() {
		System.out.println("We are inside the no arg-constructor");
	}
	
	

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}



	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("We are inside the set fortune method");
		this.fortuneService = fortuneService;
	}



	@Override
	public String getDailyWorkout() {
		return "practice fast bowling daily for 30min anf 15sec";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.grtFortune();
	}

}
