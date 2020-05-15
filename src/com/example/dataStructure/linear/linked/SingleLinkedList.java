package com.example.dataStructure.linear.linked;

import com.example.dataStructure.linear.AbstractList;

/**
 * create by Freedom on 2020/5/14
 */
public class SingleLinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    public void add(E element) {
        add(size, element);
    }


    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == 0) {
            first = new Node<>(element, null);
        } else {
            Node<E> node = node(index - 1);//减一是因为插入的位置应该是当前的位置的，所以该位置就后面挪动
            node.next = new Node<>(element, node.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheckForAdd(index);

//        Node<E> node = this.first;
        Node<E> removeNode = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> preNode = node(index - 1);
            removeNode = preNode.next;
            preNode.next = removeNode.next;
        }
        size--;
        return removeNode.element;
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

    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = this.first;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void reverseList() {
        first = reverseList2(first);
    }

    private Node<E> reverseList(Node<E> node) {
        if (node == null || node.next == null) { //链表为空直接返回，而node.next为空是递归基
            return node;
        }
        Node<E> newHead = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    private Node<E> reverseList2(Node<E> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<E> newHead = null;
        while (head != null) {
            Node<E> tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
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

            string.append(node.element);

            node = node.next;
        }
        string.append("]");

//		Node<E> node1 = first;
//		while (node1 != null) {
//
//
//			node1 = node1.next;
//		}
        return string.toString();
    }
}
