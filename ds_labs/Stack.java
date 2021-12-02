package ds_labs;

public interface Stack {
	void push(Object i);
	Object pop() throws StackEmptyException;
	Object top() throws StackEmptyException;
	int size();
	boolean isEmpty();

}
