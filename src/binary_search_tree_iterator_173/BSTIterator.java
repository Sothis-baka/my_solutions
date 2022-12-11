package binary_search_tree_iterator_173;

import structures.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/*
    Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
    BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
    boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
    int next() Moves the pointer to the right, then returns the number at the pointer.
 */
public class BSTIterator {
    TreeNode cur;
    Stack<TreeNode> pending = new Stack<>();
    public BSTIterator(TreeNode root) {
        updateCur(root);
    }

    public int next() {
           int val = cur.val;
           if(cur.right != null) updateCur(cur.right);
           else cur = pending.isEmpty() ? null : pending.pop();

           return val;
    }

    private void updateCur(TreeNode root){
        while (root.left != null) {
            pending.push(root);
            root = root.left;
        }
        cur = root;
    }

    public boolean hasNext() {
        return cur != null;
    }
}
