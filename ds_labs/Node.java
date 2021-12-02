package ds_labs;

public class Node implements Position{
	private Object element;
	Node next;
	public Node(Object i) {
		element = i;
	}
	
	public Object element() {
		return element;
	}
	
}
