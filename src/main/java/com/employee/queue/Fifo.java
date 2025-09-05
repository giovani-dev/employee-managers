package com.employee.queue;


public class Fifo<T> extends CommonQueue<T> {
    @Override
    public T dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        T element = this.head.data;
        this.head = head.next;
        size--;
        return element;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
