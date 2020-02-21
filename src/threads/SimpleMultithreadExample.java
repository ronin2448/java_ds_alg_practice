package threads;

public class SimpleMultithreadExample {
	
	public static void main(String[] args) {
		// make two threads and run them
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0 ; i < 30 ; i++)
				{
					try {
						Thread.sleep(500);
						System.out.println("Hello world from T1");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0 ; i < 30 ; i++)
				{
					try {
						Thread.sleep(3000);
						System.out.println("Hello world from T2");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
				}
			}
		});
		
		t1.start();
		t2.start();


	}

}
