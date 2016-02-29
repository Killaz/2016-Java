// Note: if it's not said that function change elements, then the're not changed; size = (r - l)
public class ArrayQueueADT {
    private int l = 0, r = 0;
    private Object[] elements = new Object[2];

    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
    	assert(queue != null);
        if (capacity <= queue.elements.length - queue.l && queue.r != queue.elements.length) {
            return;
		}
        Object[] newElements = new Object[2 * capacity];
        System.arraycopy(queue.elements, queue.l, newElements, 0, queue.r - queue.l);
        queue.r = queue.r - queue.l;
        queue.l = 0;
        queue.elements = newElements;
    }

	// Pre: true
	// Post: size' = size + 1 && queue[r' - 1] = element
    public static void enqueue(ArrayQueueADT queue, Object element) {
        assert(queue != null);
        ensureCapacity(queue, queue.r - queue.l + 1);
        queue.elements[queue.r++] = element;
    }

	// Pre: size > 0
	// Post: returns tail element
    public static Object element(ArrayQueueADT queue) {
        assert(queue != null && queue.r != queue.l);
        return queue.elements[queue.l];
    }

    // Pre: size > 0
    // Post: size' = size - 1 && deletes tail element
    public static Object dequeue(ArrayQueueADT queue) {
		assert(queue != null);
        Object value = element(queue);
        queue.elements[queue.l++] = null;
        return value;
    }

    // Pre: true
    // Post: returns size
    public static int size(ArrayQueueADT queue) {
		assert(queue != null);
        return queue.r - queue.l;
    }

    // Pre: true
    // Post: if queue is empty -> returns true, else -> false
    public static boolean isEmpty(ArrayQueueADT queue) {
    	assert(queue != null);
        return queue.r == queue.l;
    }

    // Pre: true
    // Post: if queue is empty -> returns true, else -> false
    public static void clear(ArrayQueueADT queue) {
    	assert(queue != null);
    	while (queue.r > queue.l) {
    		dequeue(queue);
		}
		queue.r = queue.l = 0;
		queue.elements = new Object[2];
    }

    // Pre: true
    // Post: returns array of queue elements
    public static Object[] toArray(ArrayQueueADT queue) {
    	assert(queue != null);
	    Object ans[] = new Object[queue.r - queue.l];
		System.arraycopy(queue.elements, queue.l, ans, 0, queue.r - queue.l);
		return ans;
    }
}
