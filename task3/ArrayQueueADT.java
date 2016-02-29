public class ArrayQueueADT {
    private int l = 0, r = 0;
    private Object[] elements = new Object[2];

    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
    	assert(queue != null);
        if (capacity <= queue.elements.length - queue.l && queue.r != queue.elements.length)
            return;
        Object[] newElements = new Object[2 * (queue.r - queue.l)];
        for (int i = 0; i < queue.l + queue.r; i++) {
            newElements[i] = queue.elements[queue.l + i];
        }
        queue.elements = newElements;
    }

    public static void enqueue(ArrayQueueADT queue, Object element) {
        assert(element != null);
        ensureCapacity(queue, queue.r - queue.l + 1);
//        System.out.printf("l = %d, r = %d, size = %d\n", queue.l, queue.r, queue.elements.length);
        queue.elements[queue.r++] = element;
    }

    public static Object element(ArrayQueueADT queue) {
        assert(queue.r != queue.l);
        return queue.elements[queue.l];
    }

    public static Object dequeue(ArrayQueueADT queue) {
        Object value = element(queue);
        queue.elements[queue.l++] = 0;
        return value;
    }

    public static int size(ArrayQueueADT queue) {
        return queue.r - queue.l;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.r == queue.l;
    }

    public static void clear(ArrayQueueADT queue) {
    	while (queue.r > queue.l)
    		dequeue(queue);
    }
}
