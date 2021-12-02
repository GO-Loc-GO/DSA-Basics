package ds_labs;

public interface Queue{
	public void enqueue(Object element); 
	public Object dequeue() throws QueueEmptyException;
	public Object front() throws QueueEmptyException; 
	public int size();
	public boolean isEmpty();
}
