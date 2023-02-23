package add_two_numbers_2;

/*
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.
*/
public class Main {
    /* provided structure */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        l1 = new ListNode(9, l1);
        l1 = new ListNode(9, l1);
        l1 = new ListNode(9, l1);
        l1 = new ListNode(9, l1);
        ListNode l2 = new ListNode(9);
        l2 = new ListNode(9, l2);
        l2 = new ListNode(9, l2);

        ListNode result = addTwoNumbers(l1, l2);

        printListNode(l1);
        printListNode(l2);
        printListNode(result);
    }

    /* helper function to print the structure */
    public static void printListNode(ListNode result){
        while(true){
            System.out.print(result.val);
            if(result.next != null){
                result = result.next;
            }else {
                System.out.println();
                break;
            }
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode pointer = result;

        int overflow = 0;

        while(true){
            int digit = l1.val + l2.val + overflow;

            // if it is not a single digit, mark it
            if(digit > 9){
                digit -= 10;
                overflow = 1;
            }else {
                overflow = 0;
            }

            pointer.next = new ListNode(digit);
            pointer = pointer.next;

            if(l1.next == null && l2.next == null){
                // leading 1
                if(overflow == 1){
                    pointer.next = new ListNode(1);
                }

                return result.next;
            }

            if(l1.next != null){
                l1 = l1.next;
            }else {
                // otherwise next time it will be added to the digit
                if(l1.val != 0){
                    l1 = new ListNode();
                }
            }

            if(l2.next != null) {
                l2 = l2.next;
            }else {
                // otherwise next time it will be added to the digit
                if(l2.val != 0){
                    l2 = new ListNode();
                }
            }
        }
    }
}
