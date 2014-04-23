package Task2;

public class Semaphore {

	private int value;
	private final int originalSize;// Remove verification?
	
	public Semaphore(int count) {
		this.value = count;
		this.originalSize = count;// Remove verification?
	}
	
	public synchronized void waitForSemaphore(String info) throws InterruptedException {
		System.out.println("Wait requested by: " + info);
		while (value <= 0) {wait();}
		System.out.println("Semaphore waited and gave access, orig size: " + originalSize);
		value--;
	}
	
	public synchronized void notifySemaphore() {
		value++;
		notifyAll();
	}

}
