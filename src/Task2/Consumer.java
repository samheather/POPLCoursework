package Task2;

public class Consumer extends Thread {
	
	private Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (true) {
//			System.out.println("Consumer Loop Entered");
			try {
				System.out.println(buffer.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("Consumer Loop Exited");
		}
		
	}

}
