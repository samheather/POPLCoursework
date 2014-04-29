package Task3;

public class Buffer {
	
	private int[] buffer = new int[] {0,0};
	private int start = 0;
	private int last = 0;
	private int size = 2;
	private int numberInBuffer = 0;
	
	public synchronized void put(int input) throws InterruptedException {
		while (numberInBuffer == size) {wait();}
		buffer[last] = input;
		last = (last + 1) % size;
		numberInBuffer++;
		notifyAll();
	}
	
	public synchronized int get() throws InterruptedException {
		while (numberInBuffer == 0) {wait();}
		int temp = buffer[start];
		start = (start + 1) % size;
		numberInBuffer--;
		notifyAll();
		return temp;
	}
}
