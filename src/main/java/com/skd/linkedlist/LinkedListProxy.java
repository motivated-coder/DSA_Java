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

    public void append(int value){
    Node newNode = new Node(value);
    if(length == 0){
        head = newNode;
        tail = newNode;
        length = 1;
    }
    else {
      /*  Node temp = head;
        for(int i = 0 ; i < length; i++){
            temp = temp.next;
        }
        temp.next = newNode;
        tail = newNode;*/
        tail.next = newNode;
        tail = newNode;
        length++;
    }
    }

     class Node{
        int value;
        Node next;

        Node(int value){
            this.value=value;
        }
    }
}
