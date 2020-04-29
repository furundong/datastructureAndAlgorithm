package com.example.dataStructure.tree.heap.binaryHeap;

import com.example.dataStructure.tree.heap.AbstractHeap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * create by Freedom on 2020/4/26
 * 注意这个heap的E，必须是comparable的实现类，不然你在比较的时候会抛异常。
 */
//二叉堆
public class BinaryHeap<E> extends AbstractHeap<E> {
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(Comparator<E> comparator, E[] elements) {
        super(comparator);
        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
//            this.elements = elements; 这样写是浅拷贝，同一个地址。
            size = elements.length;
            int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }
    }

    //批量建堆
    private void heapify() {
        //自上而下的上滤, 效率nlogn
//        for (int i = 1; i < size; i++) {
//            siftUp(i);
//        }

        //自下而上的下滤  O（n）
        for (int i = (size >> 1) - 1; i >= 0; i++) { //从非叶子节点的index开始,-1是最后一个index
            siftDown(i);
        }
    }

    public BinaryHeap(E[] elements) {
        this(null, elements);
    }

    public BinaryHeap(Comparator<E> comparator) {
        this(comparator, null);
    }

    public BinaryHeap() {
        this(null, null);
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
        siftUp(size - 1); //最后一个索引数据
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
        elementNotNullCheck(element);

        E root = null;
        if (size == 0) {
            elements[size++] = element;
        } else {
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        }

        return root;
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

            if (rightChildIndex < size && compare(elements[rightChildIndex], leftChild) > 0) { //右边比左边大
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
            int parent = (index - 1) >> 1;
            E p = elements[parent];
            if (compare(e, p) <= 0) return;

            //交换,这里可以优化一下，不需要交换，跟父节点比比，直到最后。
            E temp = elements[index];
            elements[index] = elements[parent];
            elements[parent] = temp;

            //重新赋值index
            index = parent;
        }
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
