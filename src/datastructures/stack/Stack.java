package datastructures.stack;

import datastructures.linkedlist.LinkedList;

public class Stack {

    private Node top;
    private int height;

    class Node{
        int value;
        Node next;
        Node(int val){
            this.value =val;
        }
    }

    public Stack(int val){
        Node newNode = new Node(val);
        top = newNode;
        height = 1;

    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (height == 0) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
        System.out.println("Height:" + height);
        System.out.println("\nStack:");
        if (height == 0) {
            System.out.println("empty");
        } else {
            printStack();
        }
    }

    public void makeEmpty() {
        top = null;
        height = 0;
    }

    public void push(int val){
        Node newNode = new Node(val);
        if(height==0){
            top=newNode;
        }
        else{
            newNode.next =top;
            top = newNode;
        }
        height++;
    }

    public Node pop(){
        Node temp = top;
        if(height==0){
            return null;
        }
        else{
            top = top.next;
            temp.next=null;
        }
        height--;
        return temp;
    }
}
