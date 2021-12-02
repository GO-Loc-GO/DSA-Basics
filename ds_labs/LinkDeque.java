package ds_labs;

public class LinkDeque implements Deque {
	private DENode first=null;
	private DENode last=null;
	private int size=0;
	@Override
	public void addFirst(Object o) {
		DENode N = new DENode(o);
		if(isEmpty()) {
			first = N;
			last = N;
			first.next = null;
			first.previous = null;
		}else{
			N.next = first;
			N.previous = null;
			first.previous=N;
			first = N;
		}
		size++;
	}

	@Override
	public void addLast(Object o) {
		DENode N = new DENode(o);
		if(isEmpty()) {
			last = N;
			first =N;
			last.next = null;
			last.previous = null;
		}else{
			N.next = null;
			N.previous = last;
			last.next = N;
			last = N;
		}
        size++;
	}

	@Override
	public Object removeFirst() throws EmptyDequeException {
		if(isEmpty()) {
			throw new EmptyDequeException();
		}
		Object element = first.element();
		if(size()==1) {
			first=null;
			last=null;
		}else{
			DENode af = first.next;
			af.previous = null;
			first = af;
		}
		size--;
		return element;
	}

	@Override
	public Object removeLast() throws EmptyDequeException {
		if(isEmpty()) {
			throw new EmptyDequeException();
		}
		Object element = last.element();
		if(size()==1) {
			first=null;
			last=null;
		}else{
			DENode bl = last.previous;
			bl.next = null;
			last = bl;
		}
		size--;
		return element;
	}

	@Override
	public Object getFirst() throws EmptyDequeException {
		if(isEmpty()) {
			throw new EmptyDequeException();
		}
		Object temp = first.element();
		return temp;
	}

	@Override
	public Object getLast() throws EmptyDequeException {
		if(isEmpty()) {
			throw new EmptyDequeException();
		}
		Object temp = last.element();
		return temp;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}
	public void ForwardTraverse() {
		DENode loc = first;
		while(loc!=null) {
			System.out.print(loc.element()+" ");
			loc=loc.next;
		}
		System.out.print("\n");
	}
	public void BackwardTraverse() {
		DENode loc = last;
		while(loc!=null) {
			System.out.print(loc.element()+" ");
			loc=loc.previous;
		}
		System.out.print("\n");
	}
}
