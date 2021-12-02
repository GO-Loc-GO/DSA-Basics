package ds_labs;

public class LinkQueue implements Queue{
	private Node front=null;
	private Node rear=null;
	private int size=0; 

	@Override
	public void enqueue(Object element) {
		Node N = new Node(element);
		if (size==0) {
			front=N;
		}else {
			rear.next=N;
		}
		rear=N;
		size++;
		
	}

	@Override
	public Object dequeue() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException();
		}
		int i=(int)front.element();
		front=front.next;
		size--;
		return i;
	}

	@Override
	public Object front() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException();
		}
		return (int)front.element();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}
	

}
