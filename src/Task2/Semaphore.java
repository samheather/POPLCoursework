package Task2;

public class Semaphore {

	private int value;
	
	public Semaphore(int count) {
		this.value = count;
	}
	
	public synchronized void acquire() throws InterruptedException {
		while (value <= 0) {wait();}
		value--;
	}
	
	public synchronized void release() {
		value++;
		notifyAll();
	}
	
	public synchronized int getCurrentValue() {
		return value;		
	}

}
