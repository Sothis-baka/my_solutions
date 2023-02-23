package reorder_list_143;

import structures.ListNode;

import java.util.Set;

/*
    You are given the head of a singly linked-list. The list can be represented as:

    L0 → L1 → … → Ln - 1 → Ln
    Reorder the list to be on the following form:

    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class Main {
    public static void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        // Find mid
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Only one node
        if(slow == fast){
            return;
        }

        // Reverse the 2nd half
        fast = reverseList(slow.next);

        ListNode newHead = new ListNode();
        while(head != slow.next){
            newHead.next = head;
            newHead = newHead.next;
            head = head.next;

            newHead.next = fast;
            if(fast == null){
                break;
            }
            newHead = newHead.next;
            fast = fast.next;
        }

        // When total num is odd, there should be one node remain
        if(fast != null){
            newHead.next = fast;
        }
    }

    private static ListNode reverseList(ListNode node){
        ListNode pt = null;
        while (node != null){
            ListNode temp = node.next;
            node.next = pt;
            pt = node;
            node = temp;
        }
        return pt;
    }

    private static void printList(ListNode node){
        while(node != null){
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ListNode head = new ListNode(), pt = head;
        int[] nums = {1,2,3,4};
        for(int temp: nums){
            pt.next = new ListNode(temp);
            pt = pt.next;
        }

        printList(head.next);
        reorderList(head.next);
        printList(head.next);
    }
}
