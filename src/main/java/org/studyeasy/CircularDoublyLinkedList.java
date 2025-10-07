package org.studyeasy;

public class CircularDoublyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createCDLL(int nodeValue){
        head=new Node();
        Node node=new Node();
        node.value=nodeValue;
        head=node;
        tail=node;
        node.next=node;
        node.previous=node;
        size=1;
        return head;
    }

    public void insertNode(int nodeValue,int location){
        if(head==null){
            createCDLL(nodeValue);
        }else{
            Node node=new Node();
            node.value=nodeValue;
            if(location==0){
                node.previous=tail;
                node.next=head;
                head.previous=node;
                head=node;
                tail.next=node;
                size++;
            } else if (location>=size) {
                node.previous=tail;
                node.next=head;
                tail.next=node;
                head.previous=node;
                tail=node;
                size++;
            }else {
                Node current=head;
                int index=0;
                while (index<location-1){
                    current=current.next;
                    index++;
                }
                node.next=current.next;
                node.previous=current;
                node.next.previous=node;
                current.next=node;
                size++;
            }
        }
    }

    public void traverse(){
        if (head!=null){
            Node current=head;
            int index=0;
            while(index<size){
                System.out.print(current.value);
                current=current.next;
                index++;
                if(current!=head){
                    System.out.print(" -> ");
                }
            }
        }else{
            System.out.println("The CDLL does not exist");
        }
        System.out.println();
    }

    public void reverse() {
        if (head != null) {
            Node current = tail;
            int index = 0;
            while (index < size) {
                System.out.print(current.value);
                current = current.previous;
                index++;
                if (current != tail) {
                    System.out.print(" <- ");
                }
            }
        }
        System.out.println();
    }

    public void search(int nodeValue){
        if(head!=null){
            Node temp=head;
            int index=0;
            while(index<size){
                if(temp.value==nodeValue){
                    System.out.println("Value is at the index: "+index);
                    return;
                }
                temp=temp.next;
                index++;
            }
        }
        System.out.println("Node not found!!");
    }


    public void deleteNode(int location){
        if(head!=null){
            if(location==0){
                if(size==1){
                    head.next=null;
                    head.previous=null;
                    head=null;
                    tail=null;
                    size--;
                }else{
                    head=head.next;
                    head.previous=tail;
                    tail.next=head;
                    size--;
                }
            } else if (location>=size) {
                if(size==1){
                    head.next=null;
                    head.previous=null;
                    head=null;
                    tail=null;
                    size--;
                }else{
                    tail=tail.next;
                    tail.next=head;
                    head.previous=tail;
                    size--;

                }
            }else {
                Node temp=head;
                int index=0;
                while (index<location-1){
                    temp=temp.next;
                    index++;
                }
                temp.next=temp.next.next;
                temp.next.previous=temp;
            }
            size--;
        }
    }

    public void deleteCDLL(){
        if(head!=null){
            Node temp=head;
            int index=0;
            while(index<size){
                temp.previous=null;
                temp=temp.next;
                index++;
            }
            head=null;
            tail=null;
            System.out.println("CDLL has been deleted!!!");
        }
    }
}
