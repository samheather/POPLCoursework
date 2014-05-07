package Task3;

import java.util.Random;

public class Producer extends Thread {

	private BufferNonSync buffer;
	
	public Producer(BufferNonSync buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		Random randomGenerator = new Random();
		while (true) {
			int intToWrite = randomGenerator.nextInt(100);
			try {
				buffer.put(intToWrite);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
