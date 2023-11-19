
public class Program {

	public static void main(String[] args) {
		
		BufferIF buffer = new CircularBuffer(6);

		Producer producer = new Producer(buffer);
		Consumer consumer = new Consumer(buffer);

		producer.start();		
		consumer.start();
	}

}
