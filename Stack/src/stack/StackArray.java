package stack;

import exception.ExceptionIsEmpty;

public class StackArray<T> implements Stack<T> {

	private int top;
	private T[] content;
	private int maxSize;

	@SuppressWarnings("unchecked")
	StackArray(int size) {
		this.maxSize = size;
		this.content = (T[]) new Object[size];
		this.top = -1;
	}

	@Override
	public void push(T data) {
		if (!this.isFull()) {
			content[++top] = data;
		}

	}

	@Override
	public T top() throws ExceptionIsEmpty {
		if (this.isEmpty())
			throw new ExceptionIsEmpty("Empty Stack");
		return content[top];
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	public boolean isFull() {
		return this.top == this.maxSize - 1;
	}

	@Override
	public T pop() throws ExceptionIsEmpty {
		T aux = null;
		if (this.isEmpty()) {
			throw new ExceptionIsEmpty("Empty Stack");
		} else {
			aux = content[top];
			content[top] = null;
			top--;
		}
		return aux;

	}

	public String toString() {
		String stack = "";
		for (int i = top; i >= 0; i--)
			stack = stack + content[i] + "\n";
		return stack;
	}

}
