package remove_duplicates_from_sorted_list_83;

/*
    Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
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
        ListNode newHead = new ListNode();
        ListNode pt = newHead;
        while(head != null){
            int val = head.val;

            pt.next = head;
            pt = pt.next;

            // Find next value
            while(head.next != null && head.next.val == val){
                head = head.next;
            }
            head = head.next;
        }

        // Cut end pointer
        pt.next = null;
        return newHead.next;
    }
}
