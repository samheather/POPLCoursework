package Task2;

import java.util.Random;

public class Producer extends Thread {

	private Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		Random randomGenerator = new Random();
		while (true) {
//			System.out.println("Producer Loop Entered");
			int intToWrite = randomGenerator.nextInt(100);
			try {
				buffer.put(intToWrite);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("Producer Loop Exited");
		}
		
	}

}
