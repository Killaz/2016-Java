public abstract class AbstractQueue implements Queue {
	public boolean isEmpty() {
		return size() == 0;
	}

	public void clear() {
		while (!isEmpty()) {
			dequeue();
		}
	}

	public Object dequeue() {
		assert size() > 0;
		Object result = element();
		doDequeue();
		return result;
	}

	protected abstract void doDequeue();

	public Object element() {
		assert size() > 0;
		return doElement();
	}

	protected abstract Object doElement();
}
