// Note: if it's not said that function change elements, then the're not changed; size = (r - l)
public class ArrayQueue {
    private int l = 0, r = 0;
    private Object[] elements = new Object[2];

    // Pre: capacity > 0
    // Post lements.length = 2 * capacity, elements are the same
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

	// Pre: true
	// Post: size' = size + 1 && queue[r' - 1] (tail) = element
    public void enqueue(Object element) {
        ensureCapacity(r - l + 1);
        elements[r++] = element;
    }

	// Pre: size > 0
	// Post: returns [l] (head) element
    public Object element() {
        assert r != l : "l == r == " + l;
        return elements[l];
    }

    // Pre: size > 0
    // Post: size' = size - 1 && deletes head element
    public Object dequeue() {
        Object value = element();
        elements[l++] = null;
        return value;
    }

    // Pre: true
    // Post: returns size
    public int size() {
        return r - l;
    }

    // Pre: true
    // Post: if queue is empty -> returns true, else -> false
    public boolean isEmpty() {
        return r == l;
    }

    // Pre: true
    // Post: clears queue && r = l = 0 && new queue[2]
    public void clear() {
    	r = l = 0;
    	elements = new Object[2];
    }

    // Pre: true
    // Post: returns array of queue elements
    public Object[] toArray() {
    	Object ans[] = new Object[r - l];
		System.arraycopy(elements, l, ans, 0, r - l);
		return ans;
    }
}
