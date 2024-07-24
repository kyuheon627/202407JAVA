package project;

import java.time.LocalTime;

public class Project1 {

	public static void main(String[] args) {
		
		while(true) {
			LocalTime localTime = LocalTime.now();
			System.out.printf("%d:%d:%d\n", localTime.getHour(), localTime.getMinute(), localTime.getSecond());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
