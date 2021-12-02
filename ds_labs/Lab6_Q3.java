package ds_labs;

public class Lab6_Q3 {

	public static void main(String[] args) throws StackEmptyException {
		LinkStack stack = new LinkStack();
		stack.push(10);
		stack.push(5);
		int num = (int)stack.pop();
		System.out.println(num);
		num = (int)stack.pop();
		System.out.println(num);
		num = (int)stack.pop();
	}

}
