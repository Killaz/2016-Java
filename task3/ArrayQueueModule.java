// Note: if it's not said that function change elements, then the're not changed; size = (r - l)
public class ArrayQueueModule {
    private static int l = 0, r = 0;
    private static Object[] elements = new Object[2];

    // Pre: capacity > 0
    // Post lements.length = 2 * capacity, elements are the same
    private static void ensureCapacity(int capacity) {
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
    public static void enqueue(Object element) {
        ensureCapacity(r - l + 1);
        elements[r++] = element;
    }

	// Pre: size > 0
	// Post: returns [l] (head) element
    public static Object element() {
        assert(r != l);
        return elements[l];
    }

    // Pre: size > 0
    // Post: size' = size - 1 && deletes head element
    public static Object dequeue() {
        Object value = element();
        elements[l++] = null;
        return value;
    }

    // Pre: true
    // Post: returns size
    public static int size() {
        return r - l;
    }

    // Pre: true
    // Post: true
    public static boolean isEmpty() {
        return r == l;
    }

    // Pre: true
    // Post: clears queue && r = l = 0 && new queue[2]
    public static void clear() {
    	while (r > l) {
    		dequeue();
		}
		r = l = 0;
		elements = new Object[2];
    }

    // Pre: true
    // Post: returns array of queue elements
    public static Object[] toArray() {
    	Object ans[] = new Object[r - l];
		System.arraycopy(elements, l, ans, 0, r - l);
		return ans;
    }
}
