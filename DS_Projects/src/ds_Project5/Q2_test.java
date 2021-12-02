package ds_Project5;

import ds_labs.LinkQueue;

public class Q2_test {

	public static void main(String[] args) {
		LinkQueue que = new LinkQueue();
		que.enqueue(4);
		que.enqueue(5);
		que.enqueue(6);
		que.enqueue(7);
		que.enqueue(12);
		que.enqueue(23);
		que.enqueue(45);
		que.dequeue();
		que.dequeue();
		que.dequeue();
		que.enqueue(65);
		que.dequeue();
		que.dequeue();
		que.dequeue();
		que.dequeue();
		que.dequeue();
		que.dequeue();
		que.dequeue();
		
	}

}
