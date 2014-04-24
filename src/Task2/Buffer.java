package Task2;

import java.util.concurrent.Semaphore;

public class Buffer {
	
	private int[] buffer = new int[] {87,87}; // Set this to 0,0
	private int start = 0;
	private int last = 0;
	private int size = 2;
//	private Semaphore numberInBuffer = new Semaphore(0);
//	private Semaphore numberEmptySpaces = new Semaphore(2);
//	private Semaphore generalSharedDataMutex = new Semaphore(1);
	
	private Semaphore jNumberInBuffer = new Semaphore(0);
	private Semaphore jNumberEmptySpaces = new Semaphore(2);
	private Semaphore jGeneralSharedDataMutex = new Semaphore(1);
	
	public void put(int input) throws InterruptedException {
//		numberEmptySpaces.waitForSemaphore("Putter 2");
		jNumberEmptySpaces.acquire();
		System.out.println("Past put semaphore entry 1");
//		generalSharedDataMutex.waitForSemaphore("Putter 1");
		jGeneralSharedDataMutex.acquire();
		System.out.println("Past put semaphore entry 2");
//		numberInBuffer.notifySemaphore();
		jNumberInBuffer.release();
		System.out.println("Past put semaphore entry 3");
		buffer[last] = input;
		last = (last + 1) % size;
//		generalSharedDataMutex.notifySemaphore();
		jGeneralSharedDataMutex.release();
	}
	
	public int get() throws InterruptedException {
//		numberInBuffer.waitForSemaphore("Getter 1");
		jNumberInBuffer.acquire();
		System.out.println("Past get semaphore entry 1");
//		generalSharedDataMutex.waitForSemaphore("Getter 2");
		jGeneralSharedDataMutex.acquire();
		System.out.println("Past get semaphore entry 2");
//		numberEmptySpaces.notifySemaphore();
		jNumberEmptySpaces.release();
		System.out.println("Past get semaphore entry 3");
		int tempToReturn = buffer[start];
		start = (start + 1) % size; 
//		generalSharedDataMutex.notifySemaphore();
		jGeneralSharedDataMutex.release();
		return tempToReturn;
	}
}