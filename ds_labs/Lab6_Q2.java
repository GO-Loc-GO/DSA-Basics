package ds_labs;



public class Lab6_Q2 {

	public static void main(String[] args) throws StackEmptyException {
		ArrayStack stack = new ArrayStack(5);
		stack.push(5);
		stack.push(10);
		int num = (int)stack.pop();
		System.out.println(num);
		num = (int)stack.pop();
		System.out.println(num);
	}

}
