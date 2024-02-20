package datastructures.doublelinkedlist;

import datastructures.linkedlist.LinkedList;

public class DoublyLinkedList {


    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;
        Node prev;
        Node(int val){
            this.value =val;
        }
    }

    public DoublyLinkedList(int val){
        Node newNode = new Node(val);
        head = newNode;
        tail = newNode;
        length = 1;
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
    public void append(int val){
        Node newNode = new Node(val);

        if (length==0){
            head = newNode;
            tail =newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if (length==0)return null;

        Node temp = tail;

        if (length==1){
            head=null;
            tail =null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;

        }
        length--;
        return temp;
    }

    public void prepend(int val){
        Node newNode = new Node(val);
        if (length==0){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if (length==0) return null;

        Node temp = head;

        if(length==1){
            tail = null;
            head = null;
        }
        else {
            head = head.next;
            temp.next = null;
            head.prev = null;

        }
        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length)return null;
        Node temp = head;
        if ( index <= length/2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }
        else{
            temp = tail;
            for (int j =length-1;j>index;j--){
                temp=temp.prev;
            }
        }
        return temp;

    }

    public boolean set(int index,int val){
        Node temp = get(index);
        if(temp!=null){
            temp.value =val;
            return true;
        }
        return false;
    }

    public  boolean insert(int index, int val){
        if(index<0||index>length)return false;
        if (index==0){
            prepend(val);
            return true;
        }
        if (index==length){
            append(val);
            return true;
        }

        Node newNode = new Node(val);
        Node before = get(index-1);
        Node after = before.next;

        before.next = newNode;
        newNode.prev = before;

        newNode.next=after;
        after.prev =newNode;

        length ++;
        return true;
    }


    public Node remove(int index){
        if (index<0 || index>=length)return null;
        if (index==0) return removeFirst();
        if (index==length-1) return removeLast();

        Node temp = get(index);
        Node before = temp.prev;
        Node after = temp.next;

//        temp.next.prev = temp.prev;
//        temp.prev.next = temp.next;
        // this way you do not have to implement before and after nodes

        temp.prev = null;
        temp.next =null;

        before.next = after;
        after.prev = before;

        length --;
        return temp;
    }




}
