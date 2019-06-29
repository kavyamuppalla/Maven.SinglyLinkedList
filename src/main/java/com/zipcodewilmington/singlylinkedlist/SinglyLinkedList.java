package com.zipcodewilmington.singlylinkedlist;

import java.util.Arrays;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<E extends Comparable> {

    private class Node<E> implements Cloneable {

        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public E getValue() {
            return this.value;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public Node<E> clone() {
            Node clone = new Node<E>(this.getValue());
            Node nextElement = this.getNext();
            if(nextElement != null) {
                clone.setNext(nextElement.clone());
            }

            return clone;
        }
    }

    private Node<E> startElement;
    private int size;

    public void setNode(Node<E> startElement) {
        this.startElement = startElement;
    }

    public Node<E> getNode()  {
        return this.startElement;
    }

    public int getSize() {
        return this.size;
    }


    public SinglyLinkedList() {
        this.size = 0;
    }

    public void add(E element) {

        Node<E> newNode = new Node<E>(element);
        Node<E> currentNode = this.startElement;
        while(currentNode != null && currentNode.hasNext()) {
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            this.startElement = newNode;
        } else {
            currentNode.setNext(newNode);
        }

        this.size++;
    }

    public void remove(E element) {

        Node<E> currentNode = this.startElement;
        Node<E> previousNode = null;
        Node<E> nextNode = null;
        while(currentNode != null) {
            if (currentNode.getValue().equals(element)) {

                if (previousNode == null) {
                    this.startElement = currentNode;
                }
                else {
                    previousNode.setNext(currentNode.getNext());
                }

                this.size--;
                break;

            }
            currentNode = currentNode.getNext();
        }

    }

    public boolean contains(E element) {

        Node<E> currentNode = this.startElement;
        while(currentNode != null) {
            if (currentNode.getValue().equals(element)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }

        return false;
    }

    public int find(E element) {

        Node<E> currentNode = this.startElement;
        int index=0;
        while(currentNode != null) {
            if (currentNode.getValue().equals(element)) {
                return index;
            }
            index++;
            currentNode = currentNode.getNext();
        }

        return -1;
    }
    public int size() {
        return this.size;
    }

    public E get(int index) {

        Node<E> currentNode = this.startElement;
        E value = currentNode.getValue();
        while(currentNode != null && currentNode.hasNext() && index > 0) {
            currentNode = currentNode.getNext();
            value = currentNode.getValue();
            index--;
        }
        return value;
    }

    public void set(int index, E value) {

        Node<E> currentNode = this.startElement;
        while(currentNode != null && currentNode.hasNext() && index > 0) {
            currentNode = currentNode.getNext();
            index--;
        }
        currentNode.setValue(value);
    }

    public SinglyLinkedList copy() {

        SinglyLinkedList<E> copy = new SinglyLinkedList<E>();
        copy.setNode(this.getNode().clone());
        copy.size = this.size();

        return copy;
    }

    public void sort() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size - 1 - i; j ++) {
                if(get(j).compareTo(get(j + 1)) > 0) {
                    E temp = get(j);
                    set(j,get(j + 1));
                    set(j+1, temp);
                }
            }

        }
    }
}
