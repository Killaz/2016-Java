public abstract class AbstractQueue implements Queue {
	public boolean isEmpty() {
		return size() == 0;
	}

	public void clear() {
		while (!isEmpty()) {
			dequeue();
		}
	}
}