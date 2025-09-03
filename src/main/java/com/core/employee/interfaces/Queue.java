package com.core.employee.interfaces;

public interface Queue<T> {
    void enqueue(T element);

    T dequeue();

    int size();

    void clear();

    boolean isEmpty();

    boolean isFull();

    T head();

    T tail();
}
