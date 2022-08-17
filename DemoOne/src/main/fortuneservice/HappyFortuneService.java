package main.fortuneservice;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	@Override
	public String grtFortune() {
		Random random = new Random();
		
		String fortunes[]= {
				"Look up to the sky",
				"Breath in 3 times it your locky day",
				"Not be scared to take risks"
		};
		
		int index = random.nextInt(fortunes.length);
		String todaysFurtune = fortunes[index];
		return todaysFurtune;
	}

}
