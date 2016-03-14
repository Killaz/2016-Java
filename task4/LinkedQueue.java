public class LinkedQueue implements Queue {
    private int size = 0;
    private Node l, r;

    public void enqueue(Object element) {
        if (size != 0) {
	        r.next = new Node(element, null);
	        r = r.next;
		} else {
			l = r = new Node(element, null);
		}
		size++;
    }

    public Object dequeue() {
        assert size > 0;
        size--;
        Object result = l.value;
        l = l.next;
        return result;
    }

    public Object element() {
        assert size > 0;
        return l.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
	public Object[] toArray() {
		Object ans[] = new Object[size];
		int i = 0;
		Node tmp = l;
		while (tmp != null) {
			ans[i++] = tmp.value;
			tmp = tmp.next;
		}
		return ans;
	}
}
