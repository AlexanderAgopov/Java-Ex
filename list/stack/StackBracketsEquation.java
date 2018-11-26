package list.stack;

import java.util.Stack;

public class StackBracketsEquation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "1 + (3 + 2 - (2+3) * 4 - ((3+1)*(4-2)))";
		Stack<Integer> stack = new Stack<Integer>();
		boolean correctBrackets = true;
		for(int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if(ch =='(') {
				stack.push(i);
			} else {
				if(ch ==')') {
					if(stack.isEmpty()) {
						correctBrackets = false;
						break;
					}
					stack.pop();
				}
				
			}
		} 
		
		if(!stack.isEmpty()) {
			correctBrackets = false;
		}
		System.out.println("Are the brackets correct? " + correctBrackets);

	}

}
