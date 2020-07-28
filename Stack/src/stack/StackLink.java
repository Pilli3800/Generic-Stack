package stack;

import node.Node;

import exception.ExceptionIsEmpty;

public class StackLink<T> implements Stack<T> {

	private Node<T> head;
	private Node<T> next;
	private int size;

	public StackLink() {
		this.setHead(null);
		this.setNext(null);
		this.setSize(0);
	}

	@Override
	public void push(T data) {
		if (isEmpty()) {
			this.head = new Node<T>(data, this.head);
		} else {
			this.head = new Node<T>(data, this.head);
		}
		size++;

	}

	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public T top() throws ExceptionIsEmpty {
		if (this.isEmpty())
			throw new ExceptionIsEmpty("Empty Stack");
		return this.head.getData();

	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	@Override
	public T pop() {
		T aux = null;
		if (!(isEmpty())) {
			aux = this.head.getData();
			this.head = this.head.getNext();
		}
		size--;
		return aux;

	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String toString() {
		String stack = "";
		if (isEmpty()) {
			stack = "Empty";
		}
		for (Node<T> aux = this.head; aux != null; aux = aux.getNext())
			stack = stack + aux.getData().toString() + "\n";

		return stack;
	}

}
