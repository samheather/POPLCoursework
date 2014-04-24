package Task2;

public class Buffer {
	
	private int[] buffer = new int[] {0,0};
	private int start = 0;
	private int last = 0;
	private int size = 2;
	private Semaphore numberInBuffer = new Semaphore(0);
	private Semaphore numberEmptySpaces = new Semaphore(size);
	private Semaphore generalSharedDataMutex = new Semaphore(1);
	
	public void put(int input) throws InterruptedException {
		numberEmptySpaces.acquire();
		generalSharedDataMutex.acquire();
		numberInBuffer.release();
		buffer[last] = input;
		last = (last + 1) % size;
		generalSharedDataMutex.release();
	}
	
	public int get() throws InterruptedException {
		numberInBuffer.acquire();
		generalSharedDataMutex.acquire();
		numberEmptySpaces.release();
		int tempToReturn = buffer[start];
		start = (start + 1) % size;
		generalSharedDataMutex.release();
		return tempToReturn;
	}
}
