package com.example.dataStructure.tree;

import com.example.dataStructure.tree.BT.AVLTree;
import com.example.dataStructure.tree.BT.BST;
import com.example.dataStructure.tree.BT.BT;
import com.example.dataStructure.tree.printer.BinaryTrees;

/**
 * create by Freedom on 2020/5/12
 */
public class Main {
    public static void main1(String[] args) {
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
        System.out.println("==========================================================================================");

        tree.invertTree((BT.Node<Integer>) tree.root());
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

    public static void main(String[] args) {
        BST<Integer> avlTree = new AVLTree<>();
        avlTree.add(13);
        avlTree.add(14);
        avlTree.add(15);
        BinaryTrees.println(avlTree);

        avlTree.add(16);
        BinaryTrees.println(avlTree);

        avlTree.remove(13);
        BinaryTrees.println(avlTree);

    }

}

