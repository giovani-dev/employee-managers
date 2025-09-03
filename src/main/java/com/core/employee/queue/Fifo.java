package com.core.employee.queue;

import com.core.employee.interfaces.Queue;

public class Fifo<T> implements Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Fifo() {
        head = null;
        tail = null;
    }

    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<T>(element);
        if (this.isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        T element = (T) this.head.data;
        this.head = head.next;
        size--;
        return element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public T head() {
        return this.head.data;
    }

    @Override
    public T tail() {
        return this.tail.data;
    }
}
