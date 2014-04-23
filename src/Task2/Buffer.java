package Task2;

public class Buffer {
	
	private int[] buffer = new int[] {87,87}; // Set this to 0,0
	private int start = 0;
	private int last = 0;
	private int size = 2;
	private Semaphore numberInBuffer = new Semaphore(0);
	private Semaphore numberEmptySpaces = new Semaphore(2);
	private Semaphore generalSharedDataMutex = new Semaphore(1);
	
	public synchronized void put(int input) throws InterruptedException {
		generalSharedDataMutex.waitForSemaphore("Putter 1");
		System.out.println("Past put semaphore entry 1");
		numberEmptySpaces.waitForSemaphore("Putter 2");
		System.out.println("Past put semaphore entry 2");
		buffer[start] = input;
		last = (last + 1) % size;
		numberInBuffer.notifySemaphore();
		generalSharedDataMutex.notifySemaphore();
	}
	
	public synchronized int get() throws InterruptedException {
		numberInBuffer.waitForSemaphore("Getter 1");
		System.out.println("Past get semaphore entry 1");
		generalSharedDataMutex.waitForSemaphore("Getter 2");
		System.out.println("Past get semaphore entry 2");
		start = (start + 1) % size;
		int tempToReturn = buffer[myMod(start-1,size)]; 
		numberEmptySpaces.notifySemaphore();
		generalSharedDataMutex.notifySemaphore();
		return tempToReturn;
	}

	private int myMod(int input, int mod) {
		int temp = input % mod;
		if (temp < 0) {
			temp += mod;
		}
		return temp;
	}
}