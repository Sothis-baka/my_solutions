package merge_k_sorted_lists_23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
    Merge all the linked-lists into one sorted linked-list and return it.
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

    /* Use PriorQueue might be a better solution */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode newLi = new ListNode();
        List<Integer> li = new ArrayList<>();

        // Save nums to a list in order
        for(ListNode temp: lists){
            while (temp != null){
                li.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(li);

        // Convert the list to ListNodes.
        ListNode pt = newLi;
        for(int temp: li){
            pt.next = new ListNode();
            pt = pt.next;
            pt.val = temp;
        }

        return newLi.next;
    }

    public static void main(String[] args){
        int[] input1 = {1,4,5};
        ListNode head1 = new ListNode(), pt = head1;
        for (int temp: input1) {
            pt.next = new ListNode();
            pt.next.val = temp;
            pt = pt.next;
        }

        int[] input2 = {1,3,4};
        ListNode head2 = new ListNode();
        pt = head2;
        for (int temp: input2) {
            pt.next = new ListNode();
            pt.next.val = temp;
            pt = pt.next;
        }

        int[] input3 = {2,6};
        ListNode head3 = new ListNode();
        pt = head3;
        for (int temp: input3) {
            pt.next = new ListNode();
            pt.next.val = temp;
            pt = pt.next;
        }

        printNodes(head1.next);
        printNodes(head2.next);
        printNodes(head3.next);

        ListNode result = mergeKLists(new ListNode[] {head1.next, head2.next, head3.next});
        printNodes(result);
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
