
public class CircularBuffer {

	private final int BUFFER_SIZE = 4;

	private int[] buffer = new int[BUFFER_SIZE];
	private volatile int writePosition = -1;
	private volatile int readPosition = 0;

	public boolean setValue(int value) {

		if (isNotFull()) {

			int nextWritePosition = writePosition + 1;
			buffer[nextWritePosition % BUFFER_SIZE] = value; // We can map a sequence to an index in the array by using a mod operation

			writePosition++;
			return true;
		}

		return false;

	}

	public int getValue() {

		if (isNotEmpty()) {

			int nextValue = buffer[readPosition % BUFFER_SIZE]; // We can map a sequence to an index in the array by using a mod operation
			readPosition++;
			return nextValue;
		}

		return 0;
	}

	private boolean isNotFull() {
		return !(((writePosition - readPosition) + 1) >= BUFFER_SIZE);
	}

	private boolean isNotEmpty() {
		return !(writePosition < readPosition);
	}
}
