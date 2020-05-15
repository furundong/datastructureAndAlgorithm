package com.example.dataStructure.linear;


import java.util.Arrays;

/**
 * create by Freedom on 2020/5/14
 */
public class ArrayList<E> extends AbstractList<E> {

    private Object[] elementData;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};


    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    @Override
    public void clear() {
        Arrays.fill(elementData, null);
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E e = elementData(index);
        elementData[index] = element;
        return e;
    }

    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);  // Increments modCount!!
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = element;
        size++;
    }

    /**
     * 保证要有capacity的容量
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        elementData = Arrays.copyOf(elementData,newCapacity);

        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E old = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index, numMoved);

        elementData[--size] = null; // clear to let GC do its work
        return old;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        // size=3, [99, 88, 77]
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(elementData[i]);

//			if (i != size - 1) {
//				string.append(", ");
//			}
        }
        string.append("]");
        return string.toString();
    }
}
