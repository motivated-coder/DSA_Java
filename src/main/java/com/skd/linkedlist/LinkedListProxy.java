package com.skd.linkedlist;

public class LinkedListProxy {

    private Node head;
    private Node tail;
    private int length;

    public LinkedListProxy(int value){
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length = 1;
    }


     class Node{
        int value;
        Node next;

        Node(int value){
            this.value=value;
        }
    }
}
