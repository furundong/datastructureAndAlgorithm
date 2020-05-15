package com.example.dataStructure.tree.BT;

import com.example.dataStructure.tree.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * create by Freedom on 2020/5/12
 */
public class BT<E extends Comparable> implements BinaryTreeInfo {
    protected int size;
    protected Node<E> root;
    private Comparator<E> comparator;

    public BT() {
        this(null);
    }

    public BT(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void preOrder(Visitor<E> visitor) {
        if (visitor == null) return;
        preOrder(root, visitor);
    }

    private void preOrder(Node<E> root, Visitor<E> visitor) {
        if (root == null || visitor.stop) return;

//        System.out.println("root.element = " + root.element); //中，左，右
        visitor.stop = visitor.visit(root.element);
        preOrder(root.left, visitor);
        preOrder(root.right, visitor);
    }

    public void inorder(Visitor<E> visitor) {
        if (visitor == null) return;
        inorder(root, visitor);
    }

    private void inorder(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        inorder(node.left, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        inorder(node.right, visitor);
    }

    public void postOrder(Visitor<E> visitor) {
        if (visitor == null) return;
        postOrder(root, visitor);
    }

    private void postOrder(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        postOrder(node.left, visitor);
        postOrder(node.right, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }

    public void levelOrder(Visitor<E> visitor) {
        if (root == null || visitor == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (visitor.visit(node.element)) return;

            if (node.left != null)
                queue.offer(node.left);

            if (node.right != null)
                queue.offer(node.right);
        }
    }


    public boolean isComplete() {
        if (root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()) return false;

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else { // 后面遍历的节点都必须是叶子节点
                leaf = true;
            }
        }

        return true;
    }

    public void invertTree() {
        invertTree(root);
    }

    //翻转树
    private Node<E> invertTree(Node<E> root) {
        if (root == null) return null;
        Node<E> tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }


    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int heightByLevelOrder() {
        if (root == null) return 0;

        // 树的高度
        int height = 0;
        // 存储着每一层的元素数量
        int levelSize = 1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelSize--;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            if (levelSize == 0) { // 意味着即将要访问下一层
                levelSize = queue.size();
                height++;
            }
        }

        return height;
    }

    protected Node<E> predecessor(Node<E> node) {
        if (node == null) return null;

        // 前驱节点在左子树当中（left.right.right.right....）
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }

        // 从父节点、祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }

        // node.parent == null
        // node == node.parent.right
        return node.parent;
    }

    protected Node<E> successor(Node<E> node) {
        if (node == null) return null;

        // 前驱节点在左子树当中（right.left.left.left....）
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        // 从父节点、祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        return node.parent;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public static abstract class Visitor<E> {
        boolean stop;

        /**
         * @return 如果返回true，就代表停止遍历
         */
        protected abstract boolean visit(E element);
    }

    public static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }

        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }

        public Node<E> sibling() {
            if (isLeftChild()) {
                return parent.right;
            }

            if (isRightChild()) {
                return parent.left;
            }

            return null;
        }
    }


    protected Node<E> createNode(E element, Node<E> parent) {
        return new Node<>(element, parent);
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>) node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }

    protected void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    /**
     * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
     */
    protected int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2); // 如果el，没有实现comparable或者自己实现comparator，就会报错
    }
}
