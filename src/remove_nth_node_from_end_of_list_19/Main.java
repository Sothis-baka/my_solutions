package remove_nth_node_from_end_of_list_19;


import structures.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
    Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class Main {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pt1 = head, pt2 = head;

        if(head.next == null) return null;
        for(int i=0; i<n; i++) pt2 = pt2.next;
        if(pt2 == null) return head.next;

        while(pt2.next != null){
            pt1 = pt1.next;
            pt2 = pt2.next;
        }

        pt1.next = pt1.next.next;

        return head;
    }

    public static void main(String[] args){
        int[] input = {1,2};
        ListNode head = new ListNode(), pt = head;
        for (int i=0; i < input.length; i++) {
            pt.val = input[i];

            if(i == input.length -1){
                break;
            }

            pt.next = new ListNode();
            pt = pt.next;
        }

        printNodes(head);

        ListNode result = removeNthFromEnd(head, 1);

        printNodes(head);
        printNodes(result);
    }

    /* helper func */
    private static void printNodes(ListNode head){
        while (head != null){
            System.out.print(head.val);
            System.out.print(" ");

            head = head.next;
        }
        System.out.println();
    }
}
