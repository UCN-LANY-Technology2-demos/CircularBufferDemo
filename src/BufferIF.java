
public interface BufferIF {
	boolean offer(int value) throws InterruptedException;
	Integer poll() throws InterruptedException;
}
