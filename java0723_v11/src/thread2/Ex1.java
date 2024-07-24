package thread2;

public class Ex1 {

	public static void main(String[] args) {

//		Thread th = new Thread(new Th1());
		Th1 th = new Th1();
//		th.run();	// 실행안됨
		th.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("띵-");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
