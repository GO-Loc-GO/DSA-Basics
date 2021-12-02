package ds_labs;

public class ArrayStack implements Stack{
	private int maxSize;
	private Object[] values; 
	private int top;
	public ArrayStack(int size){
		maxSize = size;
		values = new Object[size];
		top = 0;
	}
	public int size(){
		return top;
	}
	public boolean isEmpty(){
		return top==0;
	}
	public Object top() throws StackEmptyException{
		if(isEmpty()) {
			throw new StackEmptyException();
		}
		return values[top-1];
	}
	public void push(Object i){
		if(top < maxSize){
			values[top] = i;
			top = top + 1;
		}
	}
	public Object pop() throws StackEmptyException{
		if(isEmpty()) {
			throw new StackEmptyException();
		}
		Object i = values[top -1];
		top = top - 1;
		return i;
		}
}
