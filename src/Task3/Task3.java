package Task3;

public class Task3 {
	
	public static void main(String[] args) {
		BufferNonSync mainBuffer = new BufferNonSync();
		
		Producer p1 = new Producer(mainBuffer);
		Producer p2 = new Producer(mainBuffer);
		
		Consumer c1 = new Consumer(mainBuffer);
		Consumer c2 = new Consumer(mainBuffer);

		p1.start();
		p2.start();
		
		c1.start();
		c2.start();
		
	}

}
