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

    public Node removeLast(){
        if(length == 0) return null;
        else if (length == 1) {
            Node temp = head;
            head = null;
            tail = null;
            length --;
            return temp;
        }
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public void prepend(int value){
        Node node = new Node(value);
        if(length == 0){
            head = node;
            tail = node;
        }
        else{
            node.next=head;
            head.prev = node;
            head=node;
        }
        length++;
    }

    public Node removeFirst(){
        Node temp = head;
        if(length == 0) return null;
        else if (length == 1) {
            head = null;
            tail = null;
            length--;
            return temp;
        }

        head=head.next;
        temp.next = null;
        head.prev=null;
        length--;
        return temp;
    }

    public Node get(int i){
        if(i < 0 || i >= length) return null;
        else if ((i+1) == 1) {
            return head;
        } else if (length == (i+1)) {
            return tail;
        } else if ((i+1) <= (length/2)) {
            i++;
            Node temp = head;
            for(int j=0;j<i;j++){
                temp = temp.next;
            }
            return temp;
        }
        else {
            Node temp = tail;
            for(int j=length;j>i+1;j--){
                temp = temp.prev;
            }
            return temp;
        }
    }

    public boolean insert(int index, int value){
        Node newNode = new Node(value);
        if(index < 0) return false;
        else if(index >= length) return false;
        else if (index == 0) {
            prepend(value);
            return true;
        } else if (index == (length - 1)) {
            append(value);
            return true;
        }
        else{
            Node node = get(index);
            node.prev.next = newNode;
            newNode.prev = node.prev;
            newNode.next = node;
            node.prev = newNode;
            length++;
            return true;
        }
    }

    public boolean set(int index, int value){
        Node node = get(index);
        if(node == null){
            return false;
        }
        else{
            node.value = value;
            return true;
        }
    }

    public Node remove(int index) {
        if (index < 0 || index > length - 1) return null;
        else if (index == 0) {
            Node temp = head;
            head = temp.next;
            head.prev = null;
            temp.next = null;
            length--;
            return temp;
        } else if (index == length-1) {
            Node temp = tail;
            tail = temp.prev;
            tail.next = null;
            temp.prev = null;
            length--;
            return temp;
        } else {
            Node node = get(index);
            Node temp = node;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            length--;
            return node;
        }

    }

}
