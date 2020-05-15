package com.example.dataStructure.tree.BT;

import java.util.Comparator;

/**
 * create by Freedom on 2020/5/12
 */
public class BST<E extends Comparable> extends BT<E> {

    public BST() {
        this(null);
    }

    public BST(Comparator<E> comparator) {
        super(comparator);
    }

    public void add(E element) {  // 二叉树添加元素没有必要， 都是一直往下加的 。 可以改用二叉搜索树
        elementNotNullCheck(element);
        // 添加第一个节点
        if (root == null) {
            root = createNode(element, null);
            size++;

            // 新添加节点之后的处理
            afterAdd(root);
            return;
        }

        // 添加的不是第一个节点
        // 找到父节点
        Node<E> parent;
        Node<E> node = root;

        int cmp = 0;
        do {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else { // 相等
                node.element = element;
                return;
            }
        } while (node != null);

        // 看看插入到父节点的哪个位置
        Node<E> newNode = createNode(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;

        afterAdd(newNode);
    }

    public void remove(E element) {
        remove(node(element));
    }

    private void remove(Node<E> node) {
        if (node == null) return;
        size--;
        if (node.hasTwoChildren()) { // 度为2的节点
            // 找到后继节点
            Node<E> s = successor(node);
            // 用后继节点的值覆盖度为2的节点的值
            node.element = s.element;
            // 删除后继节点
            node = s;
        }

//        度为2的节点，找到后继节点element覆盖后，该节点的度只会为1或者0

        // 删除node节点（node的度必然是1或者0）
        Node<E> replacement = node.left != null ? node.left : node.right;

        // node是度为1的节点
        if (replacement != null) {
            // 更改parent
            replacement.parent = node.parent;
            // 更改parent的left、right的指向
            if (node.parent == null) { // node是度为1的节点并且是根节点
                root = replacement;
            } else if (node == node.parent.left) {
                node.parent.left = replacement;
            } else { // node == node.parent.right
                node.parent.right = replacement;
            }

            // 删除节点之后的处理
            afterRemove(node);
            //下面是度为0的节点，可能是根节点或者叶子节点
        } else if (node.parent == null) { // node是叶子节点并且是根节点
            root = null;

            // 删除节点之后的处理
            afterRemove(node);
        } else { // node是叶子节点，但不是根节点
            if (node == node.parent.left) {
                node.parent.left = null;
            } else { // node == node.parent.right
                node.parent.right = null;
            }

            // 删除节点之后的处理
            afterRemove(node);
        }
    }

    /**
     * 添加node之后的调整
     *
     * @param node 新添加的节点
     */
    protected void afterAdd(Node<E> node) {
    }

    /**
     * 删除node之后的调整
     *
     * @param node 被删除的节点
     */
    protected void afterRemove(Node<E> node) {
    }

    /**
     * 根绝内容获取节点
     *
     * @param element 内容
     * @return 节点
     */
    private Node<E> node(E element) {
        elementNotNullCheck(element);
        Node<E> node = this.root;
        while (node != null) {
            int compareResult = compare(element, node.element);
            if (compareResult == 0) {
                return node;
            }
            if (compareResult > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node;
    }
}
