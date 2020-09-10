package com.xu.algs.basic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sop on 2020/1/12.
 * <p>
 * This implementation uses a singly-linked list with a static nested class Node.
 */
public class Bag<Item> implements Iterable<Item> {
    private int N; //number of elements in bag
    private Node<Item> first; //beginning of bag

    //helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Bag(){
        this.first = null;
        this.N = 0;
    }
    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    /**
     * Adds the item to this bag.
     * @param item the item to add to this bag
     */
    public void add(Item item){
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N ++;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    //an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
