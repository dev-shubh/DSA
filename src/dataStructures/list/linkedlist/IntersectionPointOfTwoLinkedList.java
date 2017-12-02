package dataStructures.list.linkedlist;

/**
 * Created by shumishra on 9/11/17.
 */
public class IntersectionPointOfTwoLinkedList {
}


/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


//Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}



class GFG
{
    int intersectPoint(Node headA, Node headB)
    {
        int m = getSize(headA);
        int n = getSize(headB);
        Node startA = headA;
        Node startB = headB;

        if(m > n) {
            int diff = m - n;
            startA = moveForward(headA, diff);
        }
        else {
            int diff = m - n;
            startB = moveForward(headB, diff);
        }

        while (startA != null && startB != null) {
            if(startA == startB) {
                return startA.data;
            }
            startA = startA.next;
            startB = startB.next;
        }
        return 0;
    }

    int getSize(Node node) {
        if(node == null) return 0;
        int size = 0;
        Node p = node;
        while(p != null) {
            size++;
            p = p.next;
        }
        return size;
    }

    Node moveForward(Node node, int k) {
        Node p = node;
        while(k > 0) {
            p = p.next;
            k--;
        }
        return p;
    }
}
