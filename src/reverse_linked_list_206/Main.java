package reverse_linked_list_206;

import structures.ListNode;

/*
    Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class Main {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null, temp;
        while(head != null){
            temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }

        return newHead;
    }
}
