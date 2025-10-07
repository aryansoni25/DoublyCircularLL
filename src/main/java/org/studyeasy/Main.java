package org.studyeasy;

public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList cdll=new CircularDoublyLinkedList();
        cdll.createCDLL(10);
        cdll.insertNode(20,1);
        cdll.insertNode(30,2);
        cdll.insertNode(40,3);
//        cdll.traverse();
//        cdll.reverse();
//        cdll.search(30);
//        cdll.deleteNode(2);
//        cdll.traverse();
        cdll.deleteCDLL();
        cdll.traverse();
    }
}