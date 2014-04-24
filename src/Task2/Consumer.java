package Task2;

public class Consumer extends Thread {
	
	private Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(buffer.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
