import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CircularBufferCondition implements BufferIF {

    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public CircularBufferCondition(int capacity) {
        buffer = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

	@Override
	public void offer(int value) throws InterruptedException {
		
		lock.lock();
        try {
            while (size == buffer.length) {
                notFull.await(); // Wait for space to become available
            }
            buffer[tail] = value;
            tail = (tail + 1) % buffer.length;
            size++;
            notEmpty.signal(); // Signal any waiting consumers
            
        } finally {
            lock.unlock();
        }
	}

	@Override
	public int poll() throws InterruptedException {
		
		lock.lock();
        try {
            while (size == 0) {
                notEmpty.await(); // Wait for data to become available
            }
            int value = buffer[head];
            head = (head + 1) % buffer.length;
            size--;
            notFull.signal(); // Signal any waiting producers
            return value;
            
        } finally {
            lock.unlock();
        }
	}
}
