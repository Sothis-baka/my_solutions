package remove_duplicates_from_sorted_list_ii_82;

/*
    Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 */
public class Main {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(), pt = newHead;
        while (head != null){
            int cur = head.val;
            if(head.next == null || head.next.val != cur){
                pt.next = head;
                pt = pt.next;
            }

            // Skip all repeated
            while(head.next != null && head.next.val == cur){
                head = head.next;
            }
            // Go next
            head = head.next;
        }

        // Cut off pointers at last
        if(newHead.next != null){
            pt.next = null;
        }

        return newHead.next;
    }
}
