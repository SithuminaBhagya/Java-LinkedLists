package datastructures.linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;
        Node(int val){
            this.value =val;
        }
    }

    public LinkedList(int val){
        Node newNode = new Node(val);
        head = newNode;
        tail = newNode;
        length =1;
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
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if (length==0) return null;
        Node temp = head;
        Node pre = head;

        while(temp.next !=null){
            pre =temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length --;

        // this second if length ==0 for the linked lists with 1 item. because above code does not clean up the node
        if(length==0){
            head =null;
            tail = null;
        }

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
            head = newNode;
        }
        length++;
    }

    public  Node removeFirst(){
        if (length==0) return null;
        Node temp = head;

        head = head.next;
        temp.next=null;
        length--;

        // this if statement is to remove the tail which will be there when the linkedlist has only one item.
        if(length==0){
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length)return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
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
        Node temp = get(index-1);
        newNode.next =temp.next;
        temp.next = newNode;
        length ++;
        return true;
    }

    public  Node remove(int index){
        if (index<0 || index>=length)return null;
        if (index==0) return removeFirst();
        if (index==length-1) return removeLast();

        Node prev = get(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next =null;
        length --;
        return temp;
    }

    public void reverse(){
        Node temp =head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        for(int i =0;i<length;i++){
            after =temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}
