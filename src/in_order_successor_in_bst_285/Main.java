package in_order_successor_in_bst_285;

import structures.TreeNode;

/*
    Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 */
public class Main {
    static TreeNode parent;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right != null){
            return p.right;
        }

        findHelper(root, p);
        return parent;
    }

    private boolean findHelper(TreeNode root, TreeNode p){
        if(root.left == p){
            parent = root;
            return true;
        }else if(root.right == p){
            parent = null;
            return true;
        }

        if(findHelper(root.left, p)){
            return true;
        }

        findHelper(root.right, p);
        return true;
    }
}