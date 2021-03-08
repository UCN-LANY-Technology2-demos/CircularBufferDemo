
public class Consumer extends Thread {

	CircularBuffer buffer;

	public Consumer(CircularBuffer buffer) {
		super("Consumer");

		this.buffer = buffer;
	}

	@Override
	public void run() {

		int sum = 0;

		try {
			for (int v = 1; v <= 8; v++) {

				Thread.sleep((int) (Math.random() * 3001));

				int r = buffer.getValue();
				sum += r;
				System.out.println(getName() + " read value: " + r);
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println(getName() + " read values totaling: " + sum);
	}
}
