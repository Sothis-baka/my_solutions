package intersection_of_two_linked_lists_160;

import structures.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
    Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
    If the two linked lists have no intersection at all, return null.
*/
public class Main {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while(headB != null){
            if(set.contains(headB)){
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }
}
