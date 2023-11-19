
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
	public boolean offer(int value) throws InterruptedException {
        if (size == buffer.length) {
            return false; // The buffer is full
        }
        buffer[tail] = value;
        tail = (tail + 1) % buffer.length;
        size++;
        return true;
    }

	@Override
	public Integer poll() throws InterruptedException {
        if (size == 0) {
           return null; // The buffer is empty
        }
        int value = buffer[head];
        head = (head + 1) % buffer.length;
        size--;
        return value;
    }

    public int size() {
        return size;
    }


}
