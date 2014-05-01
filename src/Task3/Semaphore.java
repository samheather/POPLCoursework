package Task3;

public class Semaphore {

	protected int value;

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
