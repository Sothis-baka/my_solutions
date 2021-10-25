package merge_two_sorted_lists_21;

/*
    Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 */
public class Main {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /* newL.next is the head of new list */
        ListNode newL = new ListNode();
        ListNode pt = newL;

        while(l1 != null || l2 != null){
            // Nothing is in l1, append the whole l2 to list
            if(l1 == null){
                pt.next = l2;
                break;
            }

            // Nothing is in l2, append the whole l1 to list
            if(l2 == null){
                pt.next = l1;
                break;
            }

            // Append non-larger node to list
            if(l1.val > l2.val){
                pt.next = l2;
                l2 = l2.next;
            }else{
                pt.next = l1;
                l1 = l1.next;
            }
            // Point to next node, remove its pointer to next
            pt = pt.next;
            pt.next = null;
        }

        return newL.next;
    }

    public static void main(String[] args){
        int[] input1 = {1,2};
        ListNode head1 = new ListNode(), pt = head1;
        for (int temp: input1) {
            pt.next = new ListNode();
            pt.next.val = temp;
            pt = pt.next;
        }

        int[] input2 = {0};
        ListNode head2 = new ListNode();
        pt = head2;
        for (int temp: input2) {
            pt.next = new ListNode();
            pt.next.val = temp;
            pt = pt.next;
        }

        printNodes(head1.next);
        printNodes(head2.next);

        printNodes(mergeTwoLists(head1.next, head2.next));
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
