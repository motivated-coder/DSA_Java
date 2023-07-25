package com.skd.doublelinkedlist;

public class DoubleLinkedListProxy {

    Node head;
    Node tail;
    int length;

    public DoubleLinkedListProxy(int value){
        Node node = new Node(value);
        head = node;
        tail = node;
        length = 1;
    }

    class Node{
        int value;
        Node next;
        Node prev;

        public Node(int value){
            this.value = value;
        }
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){

            head = newNode;
            tail = newNode;
        }
        else{
            tail.next=newNode;
            newNode.prev = tail;
            tail = tail.next;

        }
        length++;
    }
}
