package sec02.exam03;

public class Car {

	Tire frontLefttire = new Tire("앞왼쪽", 6);
	Tire frontRighttire = new Tire("앞오른쪽", 2);
	Tire backLefttire = new Tire("뒤왼쪽", 3);
	Tire backRighttire = new Tire("뒤오른쪽", 4);
	
	
	TireLoc run() {
		System.out.println("[자동차가 달립니다.]");
		if(frontLefttire.roll() == false) { 
			stop();
			return TireLoc.FrontLeftTire;
		}
		if(frontRighttire.roll() == false) { 
			stop();
			return TireLoc.FrontRightTire;
		}
		if(backLefttire.roll() == false) { 
			stop();
			return TireLoc.BackLeftTire;
		}
		if(backRighttire.roll() == false) { 
			stop();
			return TireLoc.BackRightTire;
		}
		return TireLoc.Noproblem;
	}
	
	void stop() {
		System.out.println("[자동차가 멈춥니다.]");
	}
	
}
