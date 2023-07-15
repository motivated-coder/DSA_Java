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
        tail.next = newNode;
        tail = newNode;
        length++;
    }
    }

    /*public void removeLast(){
        if(length == 0) return;
        else{
            Node temp = head;
            for (int i = 1; i < length -1; i++) {
                temp = temp.next;
            }
            tail = temp;
            temp.next=null;
            length--;
        }
    }*/

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
            length++;
        }
        else{
            newNode.next=head;
            head = newNode;
            length++;
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
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
