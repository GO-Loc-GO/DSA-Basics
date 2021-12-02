package ds_Project6;

import ds_labs.*;

public class Test {

	public static void main(String[] args) {
		DoubleLinkedList list1 = new DoubleLinkedList();
		Position node1 = list1.insertFirst(10);
		Position node2 = list1.insertAfter(node1, 5);
		//list1.printList();
		list1.insertBefore(node2, 6);
		//System.out.print(list1.size());
		list1.printList();
		list1.insertLast(20);
		//System.out.print(list1.size());
		list1.printList();
		list1.remove(node1);
		list1.printList();
		System.out.print(list1.size());

	}

}
