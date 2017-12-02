package dataStructures.list.linkedlist;
import java.util.*;

/**
 * Created by shumishra on 9/11/17.
 */
public class DetectLoop {
}


/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


///* Node is defined as

class GfG
{
    int detectLoop(Node head)
    {
        if(head == null) return 0;
        if(head.next == head) return 1;

        Node slow = head;
        Node fast = head;

        while(fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return 1;
        }

        return 0;
    }
    // Java program to detect loop in a linked list

}