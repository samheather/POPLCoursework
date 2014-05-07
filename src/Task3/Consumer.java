package Task3;

public class Consumer extends Thread {
	
	private BufferNonSync buffer;

	public Consumer(BufferNonSync buffer) {
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
