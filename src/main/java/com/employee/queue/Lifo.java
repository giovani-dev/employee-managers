package com.employee.queue;

import com.employee.dto.Node;

public class Lifo<T> extends CommonQueue<T> {
    private int maxSize;

    public Lifo(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void enqueue(T element) {
        if(maxSize >= size){
            super.enqueue(element);
        }
    }

    @Override
    public T dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        T element = this.tail.data;
        this.tail = tail.next;
        size--;
        return element;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
