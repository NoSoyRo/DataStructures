/*
 * Note that package is the name of the file that contains each file.
 */

package Queue;

import Nodes.Node;

class Queue implements ADTQueue {
    protected Node head;
    protected Node tail;
    protected int nData;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.nData = 0;
    }

    public void Enqueue(Object data) {
        if (this.head == null) {
            this.head = this.tail = new Node(data);
            this.nData++;
        } else {
            Node temp = new Node(data);
            this.tail.next = temp;
            this.tail = temp;
            this.nData++;
        }
    }

    public Object Take() {
        if (this.head == null) {
            return null;
        } else {
            return this.head.element;
        }
    }

    public void Dequeue() {
        if (head != null) {
            this.head = head.next;
            nData--;
        }
    }
}