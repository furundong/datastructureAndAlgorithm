package com.example.dataStructure.heap;

public interface Heap<E> {
    int size(); //元素数量

    boolean isEmpty();//是否为空

    void clear();//清空

    void add(E element);//添加

    E get();//获取堆顶元素

    E remove();//删除堆顶元素

    E replace(E element); //刪除堆顶元素同时插入一个新元素
}
