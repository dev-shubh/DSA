package dataStructures.list;

/**
 * Created by shumishra on 9/7/17.
 */
public class SinglyLinkedList {
    private Link head;
    private Link tail;
    private int size = 0;

    public boolean addAtTail(int x) {

        Link newLink = new Link(x);

        if(head == null) {
            head = newLink;
            tail = head;
            size++;
            return true;
        }
        else {
            tail.next = newLink;
            size++;
            tail = newLink;
            return true;
        }
    }

    public Link removeFromHead() {
        if (head == null) return null;
        head = head.next;
        size--;
        return head;
    }

    public class Link {
        int data;
        Link next;

        public Link(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
