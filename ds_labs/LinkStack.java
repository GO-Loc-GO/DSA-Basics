package ds_labs;

public class LinkStack implements Stack{
	private int size=0;
	private Node top;
	public void push(Object i) {
		if(size==0) {
			top = new Node(i);
			top.next = null;
			size++;
		}else {
			Node N = new Node(i);
			N.next = top;
			top=N;
			size++;
		}
	}

	@Override
	public Object pop() throws StackEmptyException{
		if(isEmpty()) {
			throw new StackEmptyException();
		}
		Object i = top.element();
		top=top.next;
		size--;
		return i;
	}

	@Override
	public Object top() throws StackEmptyException{
		if(isEmpty()) {
			throw new StackEmptyException();
		}
		return top.element();
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
