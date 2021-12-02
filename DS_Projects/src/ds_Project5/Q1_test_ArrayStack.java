package ds_Project5;

import ds_labs.ArrayStack;

public class Q1_test_ArrayStack {

	public static void main(String[] args) {
		ArrayStack stk1 = new ArrayStack(10);
		stk1.push(4);
		stk1.push(5);
		stk1.push(6);
		stk1.push(7);
		stk1.push(12);
		stk1.push(23);
		stk1.push(45);
		stk1.pop();
		stk1.pop();
		stk1.pop();
		stk1.push(65);
		stk1.pop();
		stk1.pop();
		stk1.pop();
		stk1.pop();
		stk1.pop();
		stk1.pop();
		stk1.pop();

	}

}
