package d250826.myLinkedList;

import java.util.Objects;

public class MyLinkedList<E> implements MyList<E> {

	private class Node {
		E value;
		Node next;

        public Node(E value) {
			this.value = value;
        }
	}

	private Node root;
	private Node pointer;
	private int size;
	
	public MyLinkedList() {
		this.size = 0;
	}

	@Override
	public boolean add(E e) {
		if (root == null) {
			root = new Node(e);
			pointer = root;
			size++;

			return true;
		}

		pointer.next = new Node(e);
		pointer = pointer.next;
		size++;

		return true;
	}

	@Override
	public void add(int index, E element) {
		if (index < 0  || index > size)	throw new IllegalArgumentException();

		Node tmp;
		if (index == 0) {
			tmp = root;
			root = new Node(element);
			root.next = tmp;
			size++;
		} else {
			Node curr = root;
			for (int i = 0; i < index - 1; i++) {
				curr = curr.next;
			}
			tmp = curr.next;
			curr.next = new Node(element);
			curr.next.next = tmp;
			size++;
		}

		if (index == size) {
			pointer = tmp;
		}
	}

	@Override
	public void clear() {
		root = null;
		pointer = null;
	}

	@Override
	public boolean contains(Object o) {
		Node curr = root;
		for (int i = 0; i < size; i++) {
			if (Objects.equals(curr.value, o)) return true;
			curr = curr.next;
		}

		return false;
	}

	@Override
	public E get(int index) {
		Node curr = root;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}

		return curr.value;
	}

	@Override
	public int indexOf(Object o) {
		Node curr = root;
		for (int i = 0; i < size; i++) {
			if (Objects.equals(curr.value, o)) return i;
			curr = curr.next;
		}

		return -1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		Node curr = root;
		for (int i = size - 1; i >= 0; i--) {
			if (Objects.equals(curr.value, o)) return i;
			curr = curr.next;
		}

		return -1;
	}

	@Override
	public boolean remove(Object o) {
		Node curr = root;
		Node prev = null;

		for (int i = 0; i < size; i++) {
			if (Objects.equals(curr.value, o)) {
				Node tmp = curr.next;
				prev.next = tmp;

				return true;
			}
			curr = curr.next;
			prev = curr;
		}

		return false;
	}

	@Override
	public E remove(int index) {
		Node curr = root;
		Node prev = root;

		for (int i = 0; i < index; i++) {
			prev = curr;
			curr = curr.next;
		}
		Node tmp = curr;
		prev.next = curr.next;
		size--;

		return tmp.value;
	}

	@Override
	public E set(int index, E element) {
		Node curr = root;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		E tmp = curr.value;
		curr.value = element;

		return tmp;
	}

	@Override
	public int size() {
		return size;
	}

}

