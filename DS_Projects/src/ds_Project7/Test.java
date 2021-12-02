package ds_Project7;

import ds_labs.*;

public class Test {

	public static void main(String[] args) {
		LinkDeque deque = new LinkDeque();
		deque.addFirst(10);
		deque.addLast(6);
		System.out.println(deque.size());
		deque.addLast(2);
		deque.addFirst(5);
		deque.ForwardTraverse();
		deque.BackwardTraverse();
		System.out.println(deque.size());
		int temp = (int)deque.removeFirst();
		System.out.println(temp);
		temp = (int)deque.removeLast();
		System.out.println(temp);
		System.out.println(deque.size());
	}

}
