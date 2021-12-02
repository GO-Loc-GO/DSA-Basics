package ds_labs;

public class LinkedList implements List{
	private Node head=null;
	private int size=0;
	@Override
	public Position first() {
		return head;
	}

	@Override
	public Position last() {
		Node N = head;
		if(N.next != null) {
			N = N.next;
		}
		return N;
	}

	@Override
	public Position before(Position p) {
		Node N = head;
		if(((Node)p)== head) {
			return null;
		}
		if(N.next != ((Node)p)) {
			N = N.next;
		}
		return N;
	}

	@Override
	public Position after(Position p) {
		return ((Node)p).next;
	}

	@Override
	public Position insertBefore(Position next_node, Object new_d) {
		if (next_node == null) 
		 { 
		 System.out.println("The given next node cannot be null"); 
		 return null; 
		 }
		/* 2 & 3: Allocate the Node & 
		 Put in the data*/
		 Node new_node = new Node(new_d); 
		 
		 /* 4. Make next of new Node as next_node */
		 new_node.next = ((Node)next_node); 
		 
		 /* 5. make next of prev_node as new_node */
		 ((Node)before(next_node)).next = new_node;
		 
		 size++;
		return new_node;

	}

	@Override
	public Position insertAfter(Position prev_node, Object new_d) {
		/* 1. Check if the given Node is null */
		 if (prev_node == null) 
		 { 
		 System.out.println("The given previous node cannot be null"); 
		 return null; 
		 } 
		 
		 /* 2 & 3: Allocate the Node & 
		 Put in the data*/
		 Node new_node = new Node(new_d); 
		 
		 /* 4. Make next of new Node as next of prev_node */
		 new_node.next = ((Node)prev_node).next; 
		 
		 /* 5. make next of prev_node as new_node */
		 ((Node)prev_node).next = new_node;
		 
		 size++;
		return new_node;
	}

	@Override
	public Position insertFirst(Object d) {
		/* 1 & 2: Allocate the Node & 
		 Put in the data*/
		 Node new_node = new Node(d); 
		 
		 /* 3. Make next of new Node as head */
		 new_node.next = head; 
		 
		 /* 4. Move the head to point to new Node */
		 head = new_node;
		 
		 size++;
		 return head;
	}

	@Override
	public Position insertLast(Object new_d) {
		/* 1. Allocate the Node & 
		 2. Put in the data 
		 3. Set next as null */
		 Node new_node = new Node(new_d); 
		 
		 /* 4. If the linked list is empty, then make the 
		 new node as head */
		 if (head == null) 
		 { 
		 head = new_node; 
		 
		 size++;
		 
		 return head; 
		 } 
		 
		 /* 4. This new node is going to be the last node, so 
		 make next of it as null */
		 new_node.next = null; 
		 
		 /* 5. Else traverse till the last node */
		 Node last = head; 
		 while (last.next != null) 
		 last = last.next; 
		 
		 /* 6. Change the next of last node */
		 last.next = new_node;
		 
		 size++;
		 
		 return new_node;
	}

	@Override
	public Object remove(Position p) {
		Object d = p.element();
		if(p==head) {
			head=((Node)p).next;
		}else if(((Node)p).next==null) {
			((Node)before(p)).next=null;
		}else {
			Node bp = new Node((int)before((Node)p).element());
			bp.next=((Node)p).next;
			((Node)p).next = null;
			size--;
		}
		return d;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}
	
	public void printList() { 
	 Node top = head; 
	 while (top != null) { 
		 System.out.print(top.element()+" "); 
		 top = top.next; 
	 	} 
	 }
	
	public void ForwardTraverseFrom(Node node) {
		System.out.println("Traversal in forward Direction"); 
		while (node != null) { 
			System.out.print(node.element() + " "); 
		 	node = node.next; 
		} 

    }
	
	public void BackwardTraverseFrom(Node node) {
		Node last = node; 
		while (last != null) { 
		 	last = last.next; 
		}
		System.out.println("Traversal in reverse direction"); 
		while (last != null) { 
			System.out.print(last.element() + " "); 
			last = (Node)before(last);
		}
	}
}
