package com.example.dataStructure.tree;

import com.example.dataStructure.tree.BT.AVLTree;
import com.example.dataStructure.tree.BT.BST;
import com.example.dataStructure.tree.BT.BT;
import com.example.dataStructure.tree.BT.RBTree;
import com.example.utils.printer.BinaryTrees;

/**
 * create by Freedom on 2020/5/12
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();

        tree.add(3);
        tree.add(7);
        tree.add(5);
        tree.add(1);
        tree.add(9);


        tree.add(6);

        tree.preOrder(new BT.Visitor<Integer>() {
            @Override
            protected boolean visit(Integer element) {
                System.out.println("element = " + element);
                return false;
            }
        });
        BinaryTrees.println(tree);

        System.out.println("==========================================================================================");

        tree.invertTree();
        BinaryTrees.println(tree);

        tree.preOrder(new BT.Visitor<Integer>() {
            @Override
            protected boolean visit(Integer element) {
                System.out.println("element = " + element);
                return false;
            }
        });

        BinaryTrees.println(tree);

        int i = tree.height();
        System.out.println("i = " + i);
    }

    public static void main2(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.add(13);
        avlTree.add(14);
        avlTree.add(15);
        BinaryTrees.println(avlTree);

        avlTree.add(16);
        BinaryTrees.println(avlTree);

        avlTree.remove(13);
        BinaryTrees.println(avlTree);

    }

    public static void main3(String[] args) {

        RBTree<Integer> tree = new RBTree<>();
        tree.add(14);
        tree.add(17);
        tree.add(15);
        tree.add(18);
        tree.add(8);
        tree.add(11);
        tree.add(22);
        tree.add(1);

        BinaryTrees.println(tree);
    }

}

