package rotate_list_61;

/*
    Given the head of a linked list, rotate the list to the right by k places.
 */
public class Main {
     private class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }

        // Find length
        int length = 1;
        ListNode pt = head;
        while (pt.next != null){
            pt = pt.next;
            length++;
        }

        // Find number to rotate
        k %= length;

        if(k == 0){
            return head;
        }

        k = length - k;
        pt = head;
        while(k > 1){
            pt = pt.next;
            k--;
        }

        // Record newHead address, remove pointer to that node
        ListNode newHead = pt.next;
        pt.next = null;

        // Append origin list to end of new list.
        pt = newHead;
        while(pt.next != null){
            pt = pt.next;
        }
        pt.next = head;

        return newHead;
    }
}
