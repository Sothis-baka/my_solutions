package reverse_linked_list_ii_92;

import java.util.List;

/*
    Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class Main {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        ListNode newHead = new ListNode();
        ListNode pt = newHead;

        int index = 1;
        while(index < left){
            pt.next = head;
            pt = pt.next;
            head = head.next;
            index++;
        }

        ListNode mid = head, lastOfMid = head;
        while(index <= right){
            // Update middle array by concat in reverse order
            /*
                EX: 2 -> 3,2 -> 4,3,2
             */
            ListNode upcoming = head.next;
            head.next = mid;
            mid = head;

            head = upcoming;
            index++;
        }

        // Append middle array to pointer, and concat remains to the middle array
        pt.next = mid;
        lastOfMid.next = head;

        return newHead.next;
    }

    private static void printNodes(ListNode head){
        while (head != null){
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ListNode head = new ListNode();
        ListNode pt = head;
        for(int i=1; i<6; i++){
            pt.next = new ListNode(i);
            pt = pt.next;
        }

        printNodes(head.next);
        ListNode result = reverseBetween(head.next, 2,5);
        printNodes(result);
    }
}
