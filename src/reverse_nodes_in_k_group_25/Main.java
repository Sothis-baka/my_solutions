package reverse_nodes_in_k_group_25;

import structures.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
    You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
public class Main {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(), pt = newHead;
        newHead.next = head;

        a: while(pt.next != null){
            ListNode pt1 = pt.next, pt2 = pt1, newPt = pt1;
            for(int i=0; i<k; i++){
                if(pt2 == null) break a;
                pt2 = pt2.next;
            }

            ListNode newL = null;
            while(pt1 != pt2){
                ListNode temp = pt1.next;
                pt1.next = newL;
                newL = pt1;
                pt1 = temp;
            }

            pt.next = newL;
            pt = newPt;
            newPt.next = pt1;
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
