package stack;

import exception.ExceptionIsEmpty;

public class TestStackArray {

	public static String Polaca(String operation) throws ExceptionIsEmpty {
		String posfix = new String("");
		StackArray<Character> stack = new StackArray<Character>(operation.length());
		for (int i = 0; i < operation.length(); ++i) {
			char c = operation.charAt(i);
			if (Character.isLetterOrDigit(c))
				posfix += c;
			else if (c == '(')
				stack.push(c);
			else if (c == ')') {
				while (!stack.isEmpty() && stack.top() != '(')
					posfix += stack.pop();

				if (!stack.isEmpty() && stack.top() != '(')
					return "Invalid Expression";
				else
					stack.pop();
			} else 
			{
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.top())) {
					if (stack.top() == '(')
						return "Invalid Expression";
					posfix += stack.pop();
				}
				stack.push(c);
			}

		}

		while (!stack.isEmpty()) {
			if (stack.top() == '(')
				return "Invalid Expression";
			posfix += stack.pop();
		}
		return posfix;
	}

	static int Prec(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ExceptionIsEmpty {
		StackArray<Integer> stack1 = new StackArray<Integer>(3);
		stack1.push(new Integer(3));
		stack1.push(new Integer(2));
		stack1.push(new Integer(1));
		System.out.println(stack1.isEmpty());
		System.out.println(stack1.toString());
		stack1.pop();
		System.out.println(stack1.toString());
		stack1.pop();
		System.out.println(stack1.toString());

		StackLink<Integer> stack2 = new StackLink<Integer>();
		stack2.push(new Integer(3));
		stack2.push(new Integer(2));
		stack2.push(new Integer(1));
		System.out.println(stack2.isEmpty());
		System.out.println(stack2.toString());
		System.out.println(stack2.top());
		String exp1 = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(Polaca(exp1));
		String exp2 = "(a+b)*c";
		System.out.println(Polaca(exp2));

	}

}
