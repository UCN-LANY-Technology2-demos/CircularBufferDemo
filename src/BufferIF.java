
public interface BufferIF {
	void offer(int value) throws InterruptedException;
	int poll() throws InterruptedException;
}
