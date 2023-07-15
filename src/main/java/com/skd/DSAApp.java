package com.skd;

import com.skd.linkedlist.LinkedListProxy;

public class DSAApp {
    public static void main(String[] args) {
        LinkedListProxy linkedListProxy = new LinkedListProxy(2);
        linkedListProxy.append(4);
        linkedListProxy.append(6);
        linkedListProxy.append(8);
        linkedListProxy.printList();
        linkedListProxy.removeLast();
        System.out.println("------");
        linkedListProxy.printList();
        System.out.println("------");
        linkedListProxy.printList();
        System.out.println("setting index 2 element as 12"+linkedListProxy.set(2,12));
        linkedListProxy.printList();
    }
}
