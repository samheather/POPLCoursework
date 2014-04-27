//TODO(samheather) this class needs checking

package Task2;

public class BinarySemaphore {

	private Semaphore generalSemaphore;
	
	public BinarySemaphore(int initial) {
		if (initial != 0 || initial != 1) {
			throw new IllegalArgumentException("An input integer of eiter 0 or 1 is required");
		}
		generalSemaphore = new Semaphore(initial);
	}
	
	public synchronized void acquire() throws InterruptedException {
		generalSemaphore.acquire();
	}
	
	public synchronized void release() {
		if (generalSemaphore.getCurrentValue() != 1) {
			generalSemaphore.release();
		}
	}
	
}
