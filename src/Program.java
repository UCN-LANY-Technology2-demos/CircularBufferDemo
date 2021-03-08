
public class Program {

	public static void main(String[] args) {
		CircularBuffer buffer = new CircularBuffer();

		Producer producer = new Producer(buffer);
		Consumer consumer = new Consumer(buffer);

		producer.start();

		
		consumer.start();
	}

}
