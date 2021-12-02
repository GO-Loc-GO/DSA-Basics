package ds_labs;

public class Lab7 {

	public static void main(String[] args) throws QueueEmptyException {
		ArrayQueue que1 = new ArrayQueue();
		que1.enqueue(5);
		que1.enqueue(10);
		que1.enqueue(16);
		System.out.println(que1.isEmpty());
		System.out.println(que1.size());
		System.out.println(que1.front());
		System.out.println(que1.dequeue());
		System.out.println(que1.front());
		System.out.println(que1.dequeue());
		System.out.println(que1.front());
		System.out.println(que1.dequeue());
		System.out.println(que1.front());
		System.out.println(que1.isEmpty());
		
		LinkQueue que2 = new LinkQueue();
		que2.enqueue(5);
		que2.enqueue(10);
		que2.enqueue(16);
		System.out.println(que2.isEmpty());
		System.out.println(que2.size());
		System.out.println(que2.front());
		System.out.println(que2.dequeue());
		System.out.println(que2.front());
		System.out.println(que2.dequeue());
		System.out.println(que2.front());
		System.out.println(que2.dequeue());
//		System.out.println(que2.front());
		System.out.println(que2.isEmpty());
	}

}
