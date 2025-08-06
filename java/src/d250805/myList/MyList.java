package d250805.myList;

public interface MyList<E> {

	int size();
	boolean isEmpty();
	boolean contains(Object o);

	boolean add(E e);
	boolean remove(Object o);

	void clear();

	E get(int index);
	E set(int index, E element);
	void add(int index, E element);
	E remove(int index);

	int indexOf(Object o);
	int lastIndexOf(Object o);
	
}
