
public class Producer extends Thread {

	BufferIF buffer;

	public Producer(BufferIF buffer) {
		super("Producer");

		this.buffer = buffer;
	}

	@Override
	public void run() {
		try {
			for (int v = 1; v <= 20; v++) {
				Thread.sleep((int) (Math.random() * 500));
				System.out.println(getName() + " producing value: " + v);					
				buffer.offer(v);
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println(getName() + " done producing");
	}
}
