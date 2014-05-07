package Task3;

public class BufferNonSync {

	private int[] buffer = new int[] {0,0};
	private int start = 0;
	private int last = 0;
	private final int size = 2;
	private int numberInBuffer = 0;

	// Monitor variables
	private BinarySemaphore monitorSemaphore = new BinarySemaphore(1);
	private BinarySemaphore notifyCalled = new BinarySemaphore(0);
	
	private int blocksWaitingCount = 0;
	
	public void put(int input) throws InterruptedException {
		monitorSemaphore.acquire();

		while (numberInBuffer == size) {
			// Equivalent of wait()
			blocksWaitingCount++;
			monitorSemaphore.release();
			notifyCalled.acquire();
			monitorSemaphore.acquire();
		}

		// Critical section.
		buffer[last] = input;
		last = (last + 1) % size;
		numberInBuffer++;

		// Equivalent of notifyAll()
		while (blocksWaitingCount > 0) {
			while (notifyCalled.getCurrentValue() == 1) {
				// Do nothing
			}
			blocksWaitingCount--;
			notifyCalled.release();
		}
		while (notifyCalled.getCurrentValue() != 0) {
			// Do nothing
		}

		monitorSemaphore.release();
	}

	public int get() throws InterruptedException {
		monitorSemaphore.acquire();

		while (numberInBuffer == 0) {
			// Equivalent of wait()
			blocksWaitingCount++;
			monitorSemaphore.release();
			notifyCalled.acquire();
			monitorSemaphore.acquire();
		}

		// Critical section
		int temp = buffer[start];
		start = (start + 1) % size;
		numberInBuffer--;

		// Equivalent of notifyAll()
		while (blocksWaitingCount > 0) {
			while (notifyCalled.getCurrentValue() == 1) {
				// Do nothing
			}
			blocksWaitingCount--;
			notifyCalled.release();
		}
		while (notifyCalled.getCurrentValue() != 0) {
			// Do nothing
		}

		monitorSemaphore.release();

		return temp;
		// Compiler needs to make a temp variable where the return would have been,
		// add the release for the monitor semaphore before this point and then
		// return the temp value afterwards.
	}
	
}