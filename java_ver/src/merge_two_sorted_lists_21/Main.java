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
        // Two pointers
        ListNode head = new ListNode(), pt = head;

        // Append the smaller one
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pt.next = l1;
                l1 = l1.next;
            }else{
                pt.next = l2;
                l2 = l2.next;
            }

            pt = pt.next;
        }

        // Append remain list
        if(l1 != null){
            pt.next = l1;
        }else{
            pt.next = l2;
        }

        return head.next;
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
