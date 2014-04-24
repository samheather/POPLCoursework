package Task2;

//import java.util.concurrent.Semaphore;

public class Buffer {
	
	private int[] buffer = new int[] {87,87}; // Set this to 0,0
	private int start = 0;
	private int last = 0;
	private int size = 2;
	private Semaphore numberInBuffer = new Semaphore(0);
	private Semaphore numberEmptySpaces = new Semaphore(2);
	private Semaphore generalSharedDataMutex = new Semaphore(1);
	
	public void put(int input) throws InterruptedException {
		numberEmptySpaces.acquire("Putter 2");
//		System.out.println("Past put semaphore entry 1");
		generalSharedDataMutex.acquire("Putter 1");
//		System.out.println("Past put semaphore entry 2");
		numberInBuffer.release();
//		System.out.println("Past put semaphore entry 3");
		buffer[last] = input;
		last = (last + 1) % size;
		generalSharedDataMutex.release();
	}
	
	public int get() throws InterruptedException {
		numberInBuffer.acquire("Getter 1");
//		System.out.println("Past get semaphore entry 1");
		generalSharedDataMutex.acquire("Getter 2");
//		System.out.println("Past get semaphore entry 2");
		numberEmptySpaces.release();
//		System.out.println("Past get semaphore entry 3");
		int tempToReturn = buffer[start];
		start = (start + 1) % size; 
		generalSharedDataMutex.release();
		return tempToReturn;
	}
}