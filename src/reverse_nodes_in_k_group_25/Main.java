package reverse_nodes_in_k_group_25;

import java.util.ArrayList;
import java.util.List;

/*
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
    You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
public class Main {
    /* Provided structure */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        // No action needed
        if(k==1){
            return head;
        }

        /* realHead.next is the head of result */
        ListNode realHead = new ListNode(), pt = realHead;

        /* In case remain >= k */
        while(enough(head, k)){
            ListNode reversedK = switchK(head, k);

            for(int i=0; i<k; i++){
                head = head.next;
            }

            // Append reversed nodes, move pointer to the end
            pt.next = reversedK;
            while (pt.next != null)
                pt = pt.next;
        }

        // In case there is one remain, concat it to the list.
        if(head != null){
            pt.next = head;
            while(pt.next != null)
                pt = pt.next;
        }

        // delete the next pointer at the end.
        pt.next = null;

        return realHead.next;
    }

    /* helper function to test if there are k nodes */
    private static boolean enough(ListNode head, int k){
        for(int i=0; i<k; i++){
            if(head == null){
                return false;
            }
            head = head.next;
        }

        return true;
    }

    /* Return reversed k nodes */
    private static ListNode switchK(ListNode head, int k){
        ListNode newHead = new ListNode(), pt = newHead;
        List<Integer> temp = new ArrayList<>();
        for(int i=0; i<k; i++){
            temp.add(head.val);
            head = head.next;
        }

        for(int i=k-1; i>=0; i--){
            pt.next = new ListNode();
            pt = pt.next;
            pt.val = temp.get(i);
        }

        return newHead.next;
    }

    public static void main(String[] args){
        int[] input1 = {1,2};
        ListNode head1 = new ListNode(), pt = head1;
        for (int temp: input1) {
            pt.next = new ListNode();
            pt.next.val = temp;
            pt = pt.next;
        }

        printNodes(head1.next);

        printNodes(reverseKGroup(head1.next, 2));
    }

    /* helper func */
    private static void printNodes(ListNode head){
        System.out.print("[");
        while (head != null){
            System.out.print(head.val);
            System.out.print(" ");

            head = head.next;
        }
        System.out.println("]");
    }
}
