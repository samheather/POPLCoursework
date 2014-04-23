package Task2;

public class Buffer {
	
	private int[] buffer = new int[] {87,87}; // Set this to 0,0
	private int start = 0;
	private int last = 0;
	private int numberInBuffer = 0;
	private int size = 2;
	
	public synchronized void put(int input) throws InterruptedException {
		while (numberInBuffer == size) { wait(); }
		buffer[start] = input;
		last = (last + 1) % size;
		numberInBuffer++;
		notifyAll();
	}
	
	public synchronized int get() throws InterruptedException {
		while (numberInBuffer > 0) { wait(); }
		start = (start + 1) % size;
		numberInBuffer--;
		notifyAll();
		return buffer[myMod(start-1,size)];
	}

	private int myMod(int input, int mod) {
		int temp = input % mod;
		if (temp < 0) {
			temp += mod;
		}
		return temp;
	}
}