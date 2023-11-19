
public class CircularBufferMonitor implements BufferIF {

	private int[] buffer;
    private int head;
    private int tail;
    private int size;

    public CircularBufferMonitor(int capacity) {
        buffer = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public synchronized void offer(int value) throws InterruptedException {
        while (size == buffer.length) {
            wait(); // The buffer is full
        }
        buffer[tail] = value;
        tail = (tail + 1) % buffer.length;
        size++;
        notifyAll();
    }

    public synchronized int poll() throws InterruptedException {
        while (size == 0) {
            wait(); // The buffer is empty
        }
        int value = buffer[head];
        head = (head + 1) % buffer.length;
        size--;
        notifyAll();
        return value;
    }

    public int size() {
        return size;
    }
}
