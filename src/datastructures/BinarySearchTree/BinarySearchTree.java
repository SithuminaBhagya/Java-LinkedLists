package datastructures.BinarySearchTree;

public class BinarySearchTree {


    private Node root;
    class Node{
        Node left;
        Node right;

        int value;

        Node(int val){
            this.value =val;
        }

    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int val){
        Node newNode = new Node(val);
        if (root == null){
            root =newNode;
            return true;
        }
        Node temp = root;

        while(true){

            if (newNode.value == temp.value)return false;
            if (newNode.value<temp.value){
                if (temp.left==null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
            else{
                if (temp.right==null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }

    }

    public boolean contains(int val){
        if (root==null)return false;
        Node temp = root;
        while(temp!=null){
            if (temp.value>val){
                temp =temp.left;
            }
            else if (temp.value<val){
                temp =temp.right;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
