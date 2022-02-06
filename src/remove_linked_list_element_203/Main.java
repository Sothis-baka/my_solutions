package remove_linked_list_element_203;

import structures.ListNode;

import java.util.List;

/*
    Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 */
public class Main {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }

        if(head == null){
            return null;
        }

        ListNode pt=head.next, prev=head;
        while(pt != null){
            if(pt.val == val){
                prev.next = pt.next;
            }else{
                prev = pt;
            }
            pt = pt.next;
        }

        return head;
    }
}
