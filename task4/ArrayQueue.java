// Note: if it's not said that function change elements, then the're not changed; size = (r - l)
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

	public Object element() {
		assert r != l : "l == r == " + l;
		return elements[l];
	}

	public Object dequeue() {
		Object value = element();
		elements[l++] = null;
		return value;
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
