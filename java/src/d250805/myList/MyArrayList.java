package d250805.myList;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> implements MyList<E> {
	public static final int SOFT_MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;

	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] EMPTY_ELEMENTDATA = {};
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

	Object[] elementData;
	private int size;


    public MyArrayList() {
		this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArrayList(int initialCapacity) {
		if (initialCapacity > 0) {
			this.elementData = new Object[initialCapacity];
		} else if (initialCapacity == 0) {
			this.elementData = EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException(initialCapacity + "는 사용할 수 없습니다.");
		}
    }

	private Object[] grow(int minCapacity) {
		int oldCapacity = elementData.length;
		if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
			int newCapacity = (oldCapacity + (oldCapacity >> 1) > SOFT_MAX_ARRAY_LENGTH ? 
				oldCapacity + 1 : oldCapacity + (oldCapacity >> 1));

			return elementData = Arrays.copyOf(elementData, newCapacity);
		} else {
			return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
		}
	}

	private Object[] grow() {
		return grow(size + 1);
	}

    @Override
    public int size() {
		return size;
    }

    @Override
    public boolean isEmpty() {
		return size == 0;
    }

    @Override
    public boolean contains(Object o) {
		return indexOf(o) >= 0;
    }

    @Override
    public int indexOf(Object o) {
		Object[] es = elementData;
		if (o == null) {
			for (int i = 0; i < size; i ++) {
				if (es[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o.equals(es[i])) {
					return i;
				}
			}
		}
		return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
		Object[] es = elementData;
		if (o == null) {
			for (int i = size - 1; i >= 0; i--) {
				if (es[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				return i;
			}
		}
		return -1;
    }

    @Override
    public boolean add(E e) {
		if (size == elementData.length)
			elementData = grow();
		elementData[size] = e;
		size = size + 1;
		return true;
    }

    @Override
    public void add(int index, E element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		final int s;
		Object[] elementData;
		if ((s = size) == (elementData = this.elementData).length)
			elementData = grow();
		System.arraycopy(elementData, index, elementData, index + 1, s - index);
		elementData[index] = element;
		size = s + 1;
    }

    @Override
    public E remove(int index) {
		Objects.checkIndex(index, size);
		final Object[] es = elementData;

		@SuppressWarnings("unchecked") E oldValue = (E) es[index];
		
		final int newSize;
		if ((newSize = this.size -1) > index)
			System.arraycopy(es, index + 1, es, index, newSize - index);
		es[this.size = newSize] = null;

		return oldValue;
    }

    @Override
    public boolean remove(Object o) {
		final Object[] es = elementData;
		final int size = this.size;
		int i = 0;
		found: {
			if (o == null) {
				for (; i < size; i++)
					if (es[i] == null)
						break found;
			} else {
				for (; i < size; i++)
					if (o.equals(es[i]))
						break found;
			}
			return false;
		}

		final int newSize;
		if ((newSize = this.size -1) > i)
			System.arraycopy(es, i + 1, es, i, newSize - i);
		es[this.size = newSize] = null;
		return true;
    }

    @Override
    public void clear() {
		final Object[] es = elementData;
		for (int to = size, i = size = 0; i < to; i++)
			es[i] = null;
    }

    @Override
    public E get(int index) {
		Objects.checkIndex(index, size);
		return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
		Objects.checkIndex(index, size);
		E oldValue = (E) elementData[index];
		elementData[index] = element;
		return oldValue;
    }
	
}
