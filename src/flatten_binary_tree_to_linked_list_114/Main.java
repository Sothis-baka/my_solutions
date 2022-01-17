package flatten_binary_tree_to_linked_list_114;

import structures.TreeNode;

import java.util.Stack;

/*
    Given the root of a binary tree, flatten the tree into a "linked list":

    The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
    The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */
public class Main {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        TreeNode pt = root;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
            pt.left = null;
            pt.right = node;
            pt = pt.right;
        }

        // In case only one node
        if(root.right == root){
            root.right = null;
        }
    }
}
