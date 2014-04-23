package Task2;

public class Semaphore {

	private int value;
	private final int originalSize;// Remove verification?
	
	public Semaphore(int count) {
		this.value = count;
		this.originalSize = count;// Remove verification?
	}
	
	public synchronized void waitForSemaphore() throws InterruptedException {
		while (value == 0) {wait();}
		value--;
		notifyAll();// Necessary?
	}
	
	public synchronized void notifySemaphore() {
		value++;
		notifyAll();
	}

}
