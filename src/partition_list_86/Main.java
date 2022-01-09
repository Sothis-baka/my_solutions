package partition_list_86;

import java.util.List;

/*
    Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
    You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class Main {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(), right = new ListNode(), ptL = left, ptR = right;

        while (head != null){
            if(head.val < x){
                ptL.next = head;
                ptL = ptL.next;
            }else{
                ptR.next = head;
                ptR = ptR.next;
            }

            head = head.next;
        }

        ptL.next = right.next;
        ptR.next = null;
        return left.next;
    }
}
