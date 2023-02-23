package middle_of_linked_list_876;

import structures.ListNode;

/*
    Given the head of a singly linked list, return the middle node of the linked list.
    If there are two middle nodes, return the second middle node.
 */
public class Main {
    public ListNode middleNode(ListNode head) {
        // Use two pointers, one move 1 and one move 2
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // Even count, two in middle
        if(fast.next != null){
            slow = slow.next;
        }

        return slow;
    }
}
