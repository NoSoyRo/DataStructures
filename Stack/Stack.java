package Stack;

import Nodes.Node;

public class Stack implements ADTStack {
    private Node head;
    private int nData;

    public Stack() {
        this.head = null;
        this.nData = 0;
    }

    public void addElement(Object element) {
        if (this.head != null) {
            Node curr = head;
            this.head = new Node(element);
            this.head.next = curr;
        } else {
            this.head = new Node(element);
        }
        this.nData++;
    }

    public Object takeElement() {
        if (this.head == null) {
            return null;
        } else {
            return this.head.element;
        }
    }

    public void eliminateElement() {
        this.head = this.head.next;
        this.nData--;
    }

}
