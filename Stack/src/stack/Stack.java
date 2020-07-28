package stack;

import exception.ExceptionIsEmpty;

public interface Stack<T> {
	
	public void push(T data);

	public T top() throws ExceptionIsEmpty;

	public T pop() throws ExceptionIsEmpty;

}
