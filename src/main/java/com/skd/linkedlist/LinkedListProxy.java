package com.skd.linkedlist;

import org.w3c.dom.Node;

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

    public Node removeFirst(){
        if(length == 0) return null;
        else{
            Node temp = head;
            head = head.next;
            temp.next=null;
            length--;
            if(length == 0){
                head = null;
                tail = null;
            }
            return temp;
        }
    }

    public Node get( int index){
        if(index < 0 || index > length) return null;
        else{
            Node temp = head;
            for(int i = 0; i< index ;i++){
                temp = temp.next;

            }
            return temp;
        }
    }

    public boolean set(int index, int value){

        Node node = get(index);
        if(null == node) return  false;
        else{
            node.value = value;
            return true;
        }
    }

    public boolean insert(int index, int value){

        if(index < 0 || index > length) return  false;
        if(index == 0){
            prepend(value);
            return true;
        }
        if (index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){

        if(index < 0 || index >= length) return null;
        if(index == 0){
            return removeFirst();
        }
        if (index == length - 1){
            return removeLast();
        }
        Node node = get(index - 1);
        Node temp = node.next;
        node.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        Node before = null;
        Node after = null;
        for(int i=0;i<length;i++){
            after = temp.next;
            temp.next=before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

        public int getValue(){
            return this.value;
        }
    }
}
