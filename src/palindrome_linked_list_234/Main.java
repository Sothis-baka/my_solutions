package palindrome_linked_list_234;

import structures.ListNode;

import java.util.Stack;

/*
    Given the head of a singly linked list, return true if it is a palindrome.
 */
public class Main {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow=head, fast=head;

        // Special case when not moving at all
        if(fast.next == null){
            return true;
        }else if(fast.next.next == null){
            return fast.val == fast.next.val;
        }

        Stack<Integer> cache = new Stack<>();
        while (fast.next != null && fast.next.next != null){
            cache.push(slow.val);

            fast = fast.next.next;
            slow = slow.next;
        }

        // Total number is even, current node is needed
        if(fast.next != null){
            cache.push(slow.val);
        }

        while(!cache.isEmpty()){
            slow = slow.next;
            if(slow.val != cache.pop()){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        int[] arr = {1,2,2,2,1};
        ListNode head = new ListNode(), pt = head;
        for(int num: arr){
            pt.next = new ListNode(num);
            pt = pt.next;
        }
        System.out.println(isPalindrome(head.next));
    }
}
