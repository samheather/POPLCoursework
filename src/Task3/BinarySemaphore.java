package Task3;

public class BinarySemaphore extends Semaphore {

	public BinarySemaphore(int count) {
		super(count);
	}

	@Override
	public synchronized void release() {
		if (value != 1) {
			value++;
			notifyAll();
		}
		else {
			System.out.println("Tried to release binary semaphore whislt val=1");
			System.exit(0);
		}
	}
}