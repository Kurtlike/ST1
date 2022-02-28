package fibonacci;

import java.util.ArrayList;

public class FibHeap {
    private Node min;
    private int rootsAmount;
    public int getSize(){
        return rootsAmount;
    }
    public void add(int value) {
        Node node = new Node();
        node.key = value;
        node.left = node;
        node.right = node;
        if(min == null){
            min = node;
        }else {
            insertNode(min, node);
            if(min.key > node.key) min = node;
        }
        rootsAmount++;
    }
    private void insertNode(Node destination, Node newNode){
        Node left = newNode.left;
        Node right = destination.right;
        left.right = right;
        newNode.left = destination;
        destination.right = newNode;
        right.left = left;
    }
    public int extractMin() throws NumberFormatException{
        if(min == null){
            throw new NumberFormatException();
        }
        int res = min.key;
        if(min.right == min && min.child == null){
            min = null;
            rootsAmount--;
            return res;
        }
        deleteMin();
        rootsAmount--;
        consolidate();
        return res;
    }
    private void deleteMin(){
        if(min.child == null){
            Node right = min.right;
            Node left = min.left;
            left.right = right;
            right.left = left;
            min = right;
        }
        else{
            if(min.right == min){
                min = min.child;
                min.parent = null;
            }
            else {
                Node child = min.child;
                Node left = min.left;
                Node right = min.right;
                Node childLeft = child.left;
                child.left = left;
                childLeft.right = right;
                right.left = childLeft;
                left.right = child;
                min = min.right;
            }
        }
    }
    private void consolidate(){
        ArrayList<Node> arr = fillArray(rootsAmount);
        arr.set(min.degree, min);
        Node current = min.right;
        while(arr.get(current.degree) != current){
            if(arr.get(current.degree) == null){
                arr.set(current.degree, current);
                if(min.key > current.key){
                    min = current;
                    min.parent = null;
                }
                current = current.right;
            }else {
                Node conflict = arr.get(current.degree);
                Node addTo, adding;
                if(conflict.key < current.key){
                    addTo = conflict;
                    adding = current;
                }else{
                    addTo = current;
                    adding = conflict;
                }
                Node left = adding.left;
                Node right = adding.right;
                adding.left.right = right;
                adding.right.left = left;
               adding.left = adding;
               adding.right = adding;
                if(addTo.child != null) {
                    insertNode(addTo.child, adding);
                }
                addTo.child = adding;
                adding.parent = addTo;
                arr.set(addTo.degree, null);
                addTo.degree++;
                current = addTo;
                addTo.parent = null;
            }
            if(min.key > current.key){
                min = current;
            }
        }
    }
    private ArrayList<Node> fillArray(int numbers){
        ArrayList<Node> arr = new ArrayList<>();
        for(int i = 0; i < numbers; i++){
            arr.add(null);
        }
        return arr;
    }
}
