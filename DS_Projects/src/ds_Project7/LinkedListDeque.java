package ds_Project7;

public class LinkedListDeque {
	private Node head;
	private Node tail;
	static class Node{
	//data
	int i;
	// next node in the list
	Node next;
	// previous node in the list
	Node prev;
	Node(int i){
	this.i = i;
	}
	public void displayData(){
	System.out.print(i + " ");
	} }
	// constructor
	public LinkedListDeque(){
	this.head = null;
	this.tail = null;
	}
	public boolean isEmpty(){
	return head == null; }
	public void insertFirst(int i){
	//Create a new node
	Node newNode = new Node(i);
	if(isEmpty()){
	tail = newNode;
	}
	else{
	head.prev = newNode;
	}
	newNode.next = head;
	head = newNode;
	}
	public void insertLast(int i){
	Node newNode = new Node(i);
	if(isEmpty()){
	head = newNode;
	}
	else{
	tail.next = newNode;
	newNode.prev = tail;
	}
	tail = newNode;
	}
	public Node removeFirst(){
	if(head == null){
	throw new RuntimeException("Deque is empty");
	}
	Node first = head;
	if(head.next == null){
	tail = null;
	}
	else{
	// previous of next node (new first) becomes null
	head.next.prev = null;
	}
	head = head.next;
	return first;
	}
	public Node removeLast(){
	if(tail == null){
	throw new RuntimeException("Deque is empty");
	}
	Node last = tail;
	if(head.next == null){
	head = null;
	}
	else{
	// next of previous node (new last) becomes null
	tail.prev.next = null;
	}
	tail = tail.prev;
	return last;
	}
	public int getFirst(){
	if(isEmpty()){
	throw new RuntimeException("Deque is empty");
	}
	return head.i;
	}
	public int getLast(){
	if(isEmpty()){
	throw new RuntimeException("Deque is empty");
	}
	return tail.i;
	}
	// Method for forward traversal
	public void displayForward(){
	Node current = head;
	while(current != null){
	current.displayData();
	current = current.next;
	}
	System.out.println("");
	}
	// Method to traverse and display all nodes
	public void displayBackward(){
	Node current = tail;
	while(current != null){
	current.displayData();
	current = current.prev;
	}
	System.out.println("");
	}
	public static void main(String[] args) {
		LinkedListDeque deque = new LinkedListDeque();
		deque.insertFirst(10);
		deque.insertLast(6);
		deque.insertLast(2);
		deque.insertFirst(5);
		deque.displayForward();
		deque.displayBackward();
//		System.out.println(deque.size());
		int temp = deque.removeFirst().i;
		System.out.println(temp);
		temp = deque.removeLast().i;
		System.out.println(temp);
//		System.out.println(deque.size());
//	LinkedListDeque deque = new LinkedListDeque(); 
//	//deque.getLast();
//	deque.insertFirst(2); 
//	deque.insertFirst(1);
//	deque.insertLast(3);
//	deque.insertLast(4);
//	deque.displayForward();
//	Node node = deque.removeFirst();
//	System.out.println("Node with value "+ node.i + " deleted");
//	deque.displayForward();
//	System.out.println("First element in the deque " + 
//	deque.getFirst());
//	System.out.println("Last element in the deque " + 
//	deque.getLast());
		
	}
}
