package linked_list_cycle_141;

import structures.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
    Given head, the head of a linked list, determine if the linked list has a cycle in it.
    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
    Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class Main {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> cache = new HashSet<>();

        while(head != null){
            if(cache.contains(head)){
                return true;
            }

            cache.add(head);
            head = head.next;
        }

        return false;
    }
}
