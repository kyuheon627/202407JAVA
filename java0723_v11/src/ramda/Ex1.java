package ramda;

public class Ex1 {

	public static void main(String[] args) {
		Thread th1 = new Thread(()->{
			for(int i=0; i<5; i++) {
				System.out.println("펑-");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		th1.start();

		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.println("삐-");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
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
