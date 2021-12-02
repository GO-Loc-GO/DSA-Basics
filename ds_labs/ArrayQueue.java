package ds_labs;

public class ArrayQueue implements Queue {
	private Object[] values = new Object[10];
	private int front=0;
	private int rear=0;
	
	
	

	@Override
	public void enqueue(Object element) {
		if(size()<values.length) {
		values[rear]=element;
		rear=(rear+1)%values.length;
		}
	}

	@Override
	public Object dequeue() {
		Object temp=values[front];
		front++;
		return temp;
	}

	@Override
	public Object front() {
		return values[front];
	}

	@Override
	public int size() {
		return (rear-front);
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

}
