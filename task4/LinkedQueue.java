public class LinkedQueue extends AbstractQueue {
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

	protected Object doElement() {
		return l.value;
	}

	protected void doDequeue() {
		size--;
		l = l.next;
	}

	public int size() {
		return size;
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
