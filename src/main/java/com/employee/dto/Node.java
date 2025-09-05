package com.employee.dto;

public class Node<T> {
    public Node<T> next;
    public T data;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
