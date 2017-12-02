package dataStructures.list;

import java.util.HashMap;

/**
 * Created by shumishra on 9/11/17.
 */
public class CloneLLWithRandomPointer {
}



//  Definition for singly-linked list with a random pointer.
class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  }

class Solution {


    // Efficient Solution, does not use extra space.
    public RandomListNode copyRandomListWithoutSpaceComplexity(RandomListNode head) {  // O(N) TIme O(1) Space

        if(head == null) return null;

        RandomListNode cloneHead, cloneListIterator, originalListIterator;

        originalListIterator = head;
        cloneHead = null;
        cloneListIterator = null;

        while(originalListIterator != null) {
            cloneListIterator = new RandomListNode(originalListIterator.label);
            if(originalListIterator == head) {
                cloneHead = cloneListIterator;
            }
            RandomListNode nextTemp = originalListIterator.next;
            originalListIterator.next = cloneListIterator;
            cloneListIterator.next = nextTemp;
            originalListIterator = nextTemp;
        }

        originalListIterator = head;

        while (originalListIterator != null) {
            if(originalListIterator.random == null) {
               originalListIterator.next.random = null;    // originalListIterator.next will never be null.
            }
            else {
                originalListIterator.next.random = originalListIterator.random.next;
            }
            originalListIterator = originalListIterator.next.next;
        }

        cloneListIterator = cloneHead;
        originalListIterator = head;

        while (originalListIterator != null) {
            originalListIterator.next = cloneListIterator.next;
            if (cloneListIterator.next != null) cloneListIterator.next = cloneListIterator.next.next;
            else cloneListIterator.next = null;
            originalListIterator = originalListIterator.next;
            cloneListIterator = cloneListIterator.next;
        }

        return cloneHead;
    }


    // This uses extra space.
    public RandomListNode copyRandomListWithSpaceComplexity(RandomListNode head) { // O(N) Time O(N) Space Complexity

        HashMap<RandomListNode, RandomListNode> nextPointerMap = new HashMap<>();

        if(head == null) return null;

        RandomListNode cloneHead, cloneListIterator, originalListIterator;

        cloneListIterator = cloneHead = new RandomListNode(head.label);

        originalListIterator = head;
        while (originalListIterator != null) {
            nextPointerMap.put(originalListIterator, originalListIterator.next);
            originalListIterator = originalListIterator.next;
        }

        originalListIterator = head.next;

        while(originalListIterator != null) {
            cloneListIterator.next = new RandomListNode(originalListIterator.label);
            originalListIterator = originalListIterator.next;
            cloneListIterator = cloneListIterator.next;
        }

        originalListIterator = head;
        cloneListIterator = cloneHead;

        while(originalListIterator != null) {
            RandomListNode next = originalListIterator.next;
            originalListIterator.next = cloneListIterator;
            cloneListIterator.random = originalListIterator;
            originalListIterator = next;
            cloneListIterator = cloneListIterator.next;
        }


        cloneListIterator = cloneHead;

        while (cloneListIterator != null) {
            if(cloneListIterator.random.random != null) cloneListIterator.random = cloneListIterator.random.random.next;
            else cloneListIterator.random = null;
            cloneListIterator = cloneListIterator.next;
        }

        originalListIterator = head;
        while (originalListIterator != null) {
            originalListIterator.next = nextPointerMap.get(originalListIterator);
            originalListIterator = originalListIterator.next;
        }


        return cloneHead;
    }
}