package Task2;

import java.util.concurrent.Semaphore;//

public class Task2 {
	
	public static void main(String[] args) {
		Buffer mainBuffer = new Buffer();
		Producer p1 = new Producer(mainBuffer);
		Producer p2 = new Producer(mainBuffer);
		Consumer c1 = new Consumer(mainBuffer);
		Consumer c2 = new Consumer(mainBuffer);

		p1.start();
//		p2.start();
		c1.start();
//		c2.start();
		
//		Semaphore jNumberInBuffer = new Semaphore(0);//
//		System.out.println(jNumberInBuffer.availablePermits());
//		jNumberInBuffer.release();
//		System.out.println(jNumberInBuffer.availablePermits());
//		jNumberInBuffer.release();
//		System.out.println(jNumberInBuffer.availablePermits());
//		try {
//			jNumberInBuffer.acquire();
//			jNumberInBuffer.acquire();
//			jNumberInBuffer.acquire();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(jNumberInBuffer.availablePermits());
//		
	}

}
