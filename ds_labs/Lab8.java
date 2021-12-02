package ds_labs;

public class Lab8 {
	//Function to insert node 
	public static Node insert(Node root, int item) { 
		Node temp = new Node(item); 
		Node ptr; 
		temp.next = null; 

		if (root == null) { 
			root = temp; 
		}else { 
			ptr = root; 
			while (ptr.next != null) 
				ptr = ptr.next; 
			ptr.next = temp; 
		} 
		return root; 
	} 

	public static void display(Node root) { 
		while (root != null) { 
			System.out.print( root.element() + " "); 
			root = root.next; 
		} 
	} 

	public static Node arrayToList(int arr[], int n) { 
		Node root = null; 
		for (int i = 0; i < n; i++) { 
			root = insert(root, arr[i]);
		}
		return root; 
	} 

	public static void main(String[] args) {
		//Q1
		/* Start with the empty list */
		 LinkedList llist = new LinkedList(); 
		 
		 // Insert 6. So linked list becomes 6->NUllist 
		 llist.insertLast(6); 
		 
		 // Insert 7 at the beginning. So linked list becomes 
		 // 7->6->NUllist 
		 llist.insertFirst(7); 
		 
		 // Insert 1 at the beginning. So linked list becomes 
		 // 1->7->6->NUllist 
		 llist.insertFirst(1); 
		 
		 // Insert 4 at the end. So linked list becomes 
		 // 1->7->6->4->NUllist 
		 llist.insertLast(4); 
		 
		 // Insert 8, after 7. So linked list becomes 
		 // 1->7->8->6->4->NUllist 
		 llist.insertAfter(((Node)llist.first()).next, 8); 
		 
		 System.out.println("Created Linked list is: "); 
		 llist.printList();

		 
		 //Q2
		 int arr[] = { 1, 2, 3, 4, 5 }; 
		 int n = arr.length; 
		 Node root = arrayToList(arr, n); 
		 System.out.print("\n");
		 display(root);
	}

}
