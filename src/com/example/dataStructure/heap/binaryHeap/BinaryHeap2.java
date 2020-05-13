package com.example.dataStructure.heap.binaryHeap;

import com.example.dataStructure.heap.AbstractHeap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * create by Freedom on 2020/4/26
 */
//二叉堆
public class BinaryHeap2<E> extends AbstractHeap<E> {
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap2(Comparator<E> comparator) {
        super(comparator);
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public BinaryHeap2() {
        this(null);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);

        elements[size++] = element;
        siftUp(size - 1);
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }


    @Override
    public E remove() {
        emptyCheck();
        int lastIndex = --size;
        E e = elements[0];
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        siftDown(0);
        return e;
    }

    @Override
    public E replace(E element) {
        return null;
    }

    private void siftDown(int index) {
        E e = elements[index];
        int half = size >> 1;//非叶子节点的数量。
        while (index < half) { //只要保证index不是叶子节点, 必要index小于非叶子节点的数量就可以了。这个就是全部非叶子节点索引
            //index只有左子节点，
            //index有左有右

            int leftChildIndex = (index << 1) + 1;
            E leftChild = elements[leftChildIndex];

            //右子节点
//            int rightChildIndex = (index << 1) + 2;
            int rightChildIndex = leftChildIndex + 1;

            if (rightChildIndex < size && compare(elements[rightChildIndex],leftChild)>0){ //右边比左边大
//                leftChildIndex = rightChildIndex;
//                leftChild = elements[rightChildIndex];
                leftChild = elements[leftChildIndex = rightChildIndex];
            }

            if (compare(e, leftChild) >= 0) break;

            //将子节点存放在index位置
            elements[index] = leftChild;

            index = leftChildIndex;
        }
        elements[index] = e;
    }

    private void siftUp(int index) {
        E e = elements[index];
        while (index > 0) { //说明这个值有父节点，二叉堆的父节点是 index-1)/2
            int parentIndex = (index - 1) >> 1;
            E p = elements[parentIndex];
            if (compare(e, p) <= 0) break;

            //将父元素存储在index位置。
            elements[index] = p;

            //重新赋值index
            index = parentIndex;
        }
        elements[index] = e;
    }

    private void emptyCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("argument element is empty");
        }
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity)
            return;

        //新容量是旧容量的1.5倍
        int newCapacity = oldCapacity + oldCapacity >> 1;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;

        System.out.println("oldCapacity = " + oldCapacity + " ensure to " + newCapacity);
    }


    @Override
    public String toString() {
        return "BinaryHeap{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}
