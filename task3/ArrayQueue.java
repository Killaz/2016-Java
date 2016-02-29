public class ArrayQueue {
    private int l = 0, r = 0;
    private Object[] elements = new Object[2];

    private void ensureCapacity(int capacity) {
        if (capacity <= elements.length - l && r != elements.length)
            return;
        Object[] newElements = new Object[2 * (r - l)];
        for (int i = 0; i < l + r; i++) {
            newElements[i] = elements[l + i];
        }
        elements = newElements;
    }

    public void enqueue(Object element) {
        assert(element != null);
        ensureCapacity(r - l + 1);
        elements[r++] = element;
    }

    public Object element() {
        assert(r != l);
        return elements[l];
    }

    public Object dequeue() {
        Object value = element();
        elements[l++] = 0;
        return value;
    }

    public int size() {
        return r - l;
    }

    public boolean isEmpty() {
        return r == l;
    }

    public void clear() {
    	while (r > l)
    		dequeue();
    }
}
