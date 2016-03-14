public interface Queue {
	// Pre: true
	// Post: size' = size + 1 && queue[r' - 1] = element
	void enqueue(Object element);

	// Pre: size > 0
	// Post: returns tail element
	Object dequeue();

	// Pre: size > 0
	// Post: size' = size - 1 && deletes tail element
	Object element();

	// Pre: true
	// Post: returns size
	int size();

	// Pre: true
	// Post: clears queue, size = 0
	void clear();

	// Pre: true
	// Post: if queue is empty -> returns true, else -> false
	boolean isEmpty();

	// Pre: true
	// Post: returns array of queue elements
	Object[] toArray();
}
