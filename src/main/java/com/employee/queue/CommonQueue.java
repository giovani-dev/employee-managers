package com.employee.queue;

import com.employee.dto.Node;
import com.employee.interfaces.Queue;

public abstract class CommonQueue<T> implements Queue<T> {
    protected Node<T> head;
    protected Node<T> tail;
    protected int size;

    public CommonQueue() {
        head = null;
        tail = null;
    }

    @Override
    public abstract T dequeue();

    @Override
    public abstract boolean isFull();

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<T>(element);
        if (this.isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public T getHead() {
        return head.data;
    }

    @Override
    public T getTail() {
        return tail.data;
    }
}
