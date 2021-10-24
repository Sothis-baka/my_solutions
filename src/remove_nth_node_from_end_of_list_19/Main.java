package remove_nth_node_from_end_of_list_19;


import java.util.ArrayList;
import java.util.List;

/*
    Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class Main {
    /*
        provided structure
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Length is as least 1
        assert head != null;

        /* Save pointers */
        List<ListNode> temp = new ArrayList<>();
        ListNode pt = head;
        while (pt != null){
            temp.add(pt);

            pt = pt.next;
        }

        /* Find the one to be removed */
        int index = temp.size() - n;
        /* Not sure whether it needs to modify original object */
        if(index == 0){
            if(head.next == null){
                head.val = 0;
                return null;
            }

            head.val = head.next.val;
            head.next = head.next.next;

            return head;
        }

        /* Connect adjacent two */
        temp.get(index - 1).next = temp.get(index).next;
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
