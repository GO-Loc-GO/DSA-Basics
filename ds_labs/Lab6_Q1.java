package ds_labs;

import java.util.Stack;

public class Lab6_Q1 {
    public static boolean check(String str) {
    	int i;
    	Stack<Character> stack = new Stack<Character>();
    	for(i=0;i<str.length();i++) {
    		char n = str.charAt(i);
    		if(n=='{'||n=='('||n=='[') {
    			stack.push(n);
    		    continue;
    		}
    		char temp;
    		switch(n) {
    			case')':
    				temp = stack.pop();
    				if(temp=='{'||temp=='[') {
    					return false;
    				}
    				break;
    			case']':
    				temp=stack.pop();
    				if(temp=='{'||temp=='(') {
    					return false;
    				}
    				break;
    			case'}':
    				temp=stack.pop();
    				if(temp=='('||temp=='[') {
    					return false;
    				}
    				break;
    		}
    	}
    	return(stack.isEmpty());
    }
	public static void main(String[] args) {
		String expr = "([{}])";
		if(check(expr)) {
			System.out.println("Expression is balanced");
		}else {
			System.out.println("Expression is not balanced");
		}

	}

}
