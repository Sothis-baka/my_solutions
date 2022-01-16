package convert_sorted_list_to_binary_search_tree_109;

import structures.ListNode;
import structures.TreeNode;

/*
    Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class Main {
    public static TreeNode sortedListToBST(ListNode head){
        return helper(head, null);
    }

    private static TreeNode helper(ListNode start, ListNode end){
        if(start == null){
            return null;
        }

        if(start == end){
            return new TreeNode(start.val);
        }

        // Slow will be mid node, prev will be the one before that
        ListNode prev = start, slow = start, fast = start;
        while(fast != end && fast.next != end){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Only two nodes
        if(start == slow){
            return new TreeNode(start.val, null, helper(slow.next, end));
        }
        return new TreeNode(slow.val, helper(start, prev), helper(slow.next, end));
    }

    public static void main(String[] args){
        ListNode head = new ListNode(), pt = head;
        int[] nums = new int[]{-10,-3,0,5,9};
        for(int temp: nums){
            pt.next = new ListNode(temp);
            pt = pt.next;
        }

        TreeNode result = sortedListToBST(head.next);
    }
}
