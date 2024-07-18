package sec02.exam03;

public class CarExample {
	
	public static void main(String[] args) {

		Car car = new Car();
		
		for(int i=1; i<=5; i++) {
			TireLoc problemLocation = car.run();
			
			switch(problemLocation) {
			case FrontLeftTire:
				System.out.println("앞왼쪽 HankookTire로 교체");
				car.frontLefttire = new HankookTire("앞왼쪽", 15);
				break;
			case FrontRightTire:
				System.out.println("앞오른쪽 KumhoTire로 교체");
				car.frontRighttire = new KumhoTire("앞왼쪽", 13);
				break;
			case BackLeftTire:
				System.out.println("뒤왼쪽 HankookTire로 교체");
				car.backLefttire = new HankookTire("앞왼쪽", 14);
				break;
			case BackRightTire:
				System.out.println("뒤오른쪽 KumhoTire로 교체");
				car.backRighttire = new KumhoTire("앞왼쪽", 17);
				break;
			case Noproblem:
				System.out.println("문제 없다!");
			}
			System.out.println("----------------------------------");
		}
		
		
	}

}
