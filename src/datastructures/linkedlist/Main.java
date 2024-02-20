package datastructures.linkedlist;


public class Main {

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(4);
        //myLinkedList.printList();

        //System.out.println("New Linked List Is :");
        myLinkedList.append(5);
        myLinkedList.append(33);
        myLinkedList.append(45);
        myLinkedList.append(1);

        System.out.println("Initial Linked List Is :");
        myLinkedList.printList();

        //System.out.println("Length of the linked list is : "+myLinkedList.getLength());
       // System.out.println("2nd Index item is : " + myLinkedList.get(1).value);

        System.out.println("New Linked List Is :");
        myLinkedList.set(2,999);
        myLinkedList.printList();


        System.out.println("Reversed Linked List Is :");
        myLinkedList.reverse();
        myLinkedList.printList();


    }

}