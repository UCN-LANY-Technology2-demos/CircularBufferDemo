
public class Consumer extends Thread {

	BufferIF buffer;

	public Consumer(BufferIF buffer) {
		super("Consumer");

		this.buffer = buffer;
	}

	@Override
	public void run() {

		int sum = 0;

		try {
			for (int v = 1; v <= 20; v++) {

				Thread.sleep((int) (Math.random() * 1000));

				Integer r = buffer.poll();
				if (r == null) {
					System.out.println(getName() + " no value!");
				} else {
					sum += r;
					System.out.println(getName() + " read value: " + r);
				}
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println(getName() + " read values totaling: " + sum);
	}
}
