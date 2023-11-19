
public class CircularBuffer implements BufferIF {
	private int[] buffer;
	private int head;
	private int tail;
	private int size;

	public CircularBuffer(int capacity) {
		buffer = new int[capacity];
		head = 0;
		tail = 0;
		size = 0;
	}

	@Override
	public void offer(int value) throws InterruptedException {
		if (size == buffer.length) {
			System.out.println("No room!");
			return; // The buffer is full
		}
		buffer[tail] = value;
		tail = (tail + 1) % buffer.length;
		size++;
	}

	@Override
	public int poll() throws InterruptedException {
		if (size == 0) {
			return 0; // The buffer is empty
		}
		int value = buffer[head];
		head = (head + 1) % buffer.length;
		size--;
		return value;
	}
}
