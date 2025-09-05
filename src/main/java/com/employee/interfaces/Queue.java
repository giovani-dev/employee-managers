package com.employee.interfaces;

public interface Queue<T> {
    void enqueue(T element);

    T dequeue();

    int getSize();

    void clear();

    boolean isEmpty();

    boolean isFull();

    T getHead();

    T getTail();
}
