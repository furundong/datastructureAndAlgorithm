package com.example.dataStructure.linear.circle;

import com.example.dataStructure.linear.AbstractList;

/**
 * create by Freedom on 2020/5/15
 */
public class SingleCircleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;

    /**
     * 获取index位置对应的节点对象
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);

        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == 0) {
            Node<E> newFirst = new Node<>(element, first);
            // 拿到最后一个节点
            Node<E> last = (size == 0) ? newFirst : node(size - 1);
            last.next = newFirst;
            first = newFirst;
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node<E> prev = index == 0 ? first : node(index - 1);
        Node<E> node = prev.next;
        prev.next = node.next;

        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;

                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;

                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }


    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return element + "_" + next.element;
        }
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node);

            node = node.next;
        }
        string.append("]");
        return string.toString();
    }

    public boolean hasCycle() {
       return hasCycle(first);
    }

        public boolean hasCycle(Node<E> head) {
        if (head == null || head.next == null) return false;

        Node<E>  slow = head;
        Node<E>  fast = head.next;
        while (fast != null && fast.next != null) {//如果不是环形， 最多跑两圈，fast必定为null，
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}
