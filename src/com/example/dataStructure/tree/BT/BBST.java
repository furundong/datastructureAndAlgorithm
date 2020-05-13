package com.example.dataStructure.tree.BT;

import java.util.Comparator;

/**
 * create by Freedom on 2020/5/13
 * BBST 平衡二叉树分为
 *
 * AVL树
 * 红黑树
 */
public abstract class BBST<E extends Comparable> extends BST<E>{

    public BBST() {
        this(null);
    }

    public BBST(Comparator<E> comparator) {
        super(comparator);
    }

}
