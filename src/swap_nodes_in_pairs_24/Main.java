package swap_nodes_in_pairs_24;

/*
    Given a linked list, swap every two adjacent nodes and return its head.
    You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
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

    public static ListNode swapPairs(ListNode head) {
        /* realHead.next is the head of result */
        ListNode realHead = new ListNode(), pt = realHead, temp;

        /* In case remain >= 2 */
        while(head != null && head.next != null){
            // pt.next points to the second
            pt.next = head.next;
            // move pt
            pt = pt.next;
            // save the third
            temp = pt.next;
            // pt.next points to the first
            pt.next = head;
            // move pt
            pt = pt.next;

            // head points to the third
            head = temp;
        }

        // In case there is one remain, concat it to the list.
        if(head != null){
            pt.next = head;
            pt = pt.next;
        }

        // delete the next pointer at the end.
        pt.next = null;

        return realHead.next;
    }

    public static void main(String[] args){
        int[] input1 = {1};
        ListNode head1 = new ListNode(), pt = head1;
        for (int temp: input1) {
            pt.next = new ListNode();
            pt.next.val = temp;
            pt = pt.next;
        }

        printNodes(head1.next);

        printNodes(swapPairs(head1.next));
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
