package java0723_v11;

import java.time.LocalTime;

public class DisplayDateTime {

	public static void main(String[] args) {

//		System.out.println(localTime.getHour());
//		System.out.println(localTime.getMinute());
//		System.out.println(localTime.getSecond());
		
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
