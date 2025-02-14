package com.abin.lee.algo.lc.list.single;

public class Node<E> {
    E val;
    Node<E> next ;
    Node<E> prev;

    public Node(E val, Node<E> next, Node<E> prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
