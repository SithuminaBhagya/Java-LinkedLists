package datastructures.Queue;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    class Node{
        int value;
        Node next;
        Node(int val){
            this.value =val;
        }
    }

    public Queue(int val){
        Node newNode = new Node(val);
        first = newNode;
        last = newNode;

        length = 1;

    }
    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.value);
            System.out.println("Last: " + last.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nQueue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        first = null;
        last = null;
        length = 0;
    }

    public void enqueue(int val){
        Node newNode = new Node(val);
        if(length==0){
            first=newNode;
            last = newNode;
        }
        else{
            last.next =newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        Node temp = first;
        if(length==0){
            return null;
        }
        else if (length ==1){
            first = null;
            last = null;
        }
        else{
            first = first.next;
            temp.next=null;
        }
        length--;
        return temp;
    }
}
