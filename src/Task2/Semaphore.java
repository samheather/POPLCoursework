package Task2;

public class Semaphore {

	private int value;
	
	public Semaphore(int count) {
		this.value = count;
	}
	
	public synchronized void waitForSemaphore(String info) throws InterruptedException {
		System.out.println("Wait requested by: " + info);
		while (value <= 0) {wait();}
		value--;
	}
	
	public synchronized void notifySemaphore() {
		value++;
		notifyAll();
	}

}
