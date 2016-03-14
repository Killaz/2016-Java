public class ArrayQueue extends AbstractQueue {
	private int l = 0, r = 0;
	private Object[] elements = new Object[2];

	private void ensureCapacity(int capacity) {
		if (capacity <= elements.length - l && r != elements.length) {
			return;
		}
		Object[] newElements = new Object[2 * capacity];
		System.arraycopy(elements, l, newElements, 0, r - l);
		r = r - l;
		l = 0;
		elements = newElements;
	}

	public void enqueue(Object element) {
		ensureCapacity(r - l + 1);
		elements[r++] = element;
	}

	protected Object doElement() {
		return elements[l];
	}

	protected void doDequeue() {
		elements[l++] = null;
	}

	public int size() {
		return r - l;
	}

	public Object[] toArray() {
		Object ans[] = new Object[r - l];
			System.arraycopy(elements, l, ans, 0, r - l);
			return ans;
	}
}
