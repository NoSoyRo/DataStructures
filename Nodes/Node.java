package Nodes;

public class Node implements ADTNode {
    public Object element;
    public Node next;
    public Node(Object value){
        this(value, null);
    }
    public Node(Object value, Node n){
        this.element = value;
        this.next = n;
    }
}
