// Note: if it's not said that function change elements, then the're not changed
//       head - The oldest live object of queue, if exists (or null)
//       tail - the newest object of queue, if exists (or null)
public interface Queue {
	// Pre: true
	// Post: size' = size + 1 && tail's element = element
	void enqueue(Object element);

	// Pre: size > 0
	// Post: size' = size - 1 && deletes head's element
	Object dequeue();

	// Pre: size > 0
	// Post: returns head's element
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
