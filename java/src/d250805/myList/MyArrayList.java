package d250805.myList;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> implements MyList<E> {
	public static final int SOFT_MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;

	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] EMPTY_ELEMENTDATA = {};
	/* DEFAULTCAPACITY_EMPTY_ELEMENTDATA 주석 일부
	 * We distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
	 * first element is added.
	 */
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

	/*
	 * 하나는 사용자가 직접 크기를 0으로 지정한 배열이고
	 * 다른 하나는 기본 생성자로 생성한 배열
	 * 두 개를 구분하는 이유
	 * 두 배열 모두 비어있는 배열이지만
	 * 요소를 추가했을 때 크기를 늘리는 방식이 다름
	 */


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
			// 쉬프트 연산자 기존 배열의 절반만큼 증가, grow() 메서드에 의해 최소 1 증가
			int prefLength = oldCapacity + Math.max(minCapacity - oldCapacity, (oldCapacity >> 1));

			return elementData = Arrays.copyOf(elementData, prefLength);
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
				if(o.equals(es[i])){
					return i;
				}
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
		// 배열을 복사해야되는데 멤버 변수보다 지역 변수가 접근이 빠름
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
	
	// ArrayList에서 정의한 메서드
	public void trimeToSize() {
		if (size < elementData.length) {
			elementData = (size == 0)
				? EMPTY_ELEMENTDATA
				: Arrays.copyOf(elementData, size);
		}
	}
}
