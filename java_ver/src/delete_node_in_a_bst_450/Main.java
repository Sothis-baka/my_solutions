package delete_node_in_a_bst_450;

import structures.TreeNode;

/*
    Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

    Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.
 */
public class Main {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        int val = root.val;
        if(key == val){
            if(isLeaf(root)) return null;
            deleteHelper(root);
        }else if(key > val){
            root.right = deleteNode(root.right, key);
        }else{
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    private void deleteHelper(TreeNode node){
        if(node.left == null){
            node.val = node.right.val;
            node.left = node.right.left;
            node.right = node.right.right;
        }else if(node.right == null){
            node.val = node.left.val;
            node.right = node.left.right;
            node.left = node.left.left;
        }else{
            // Use the smallest val of right node
            if(node.right.left == null){
                node.val = node.right.val;
                node.right = node.right.right;
            }else{
                node.val = getSmallest(node.right);
            }
        }
    }

    private int getSmallest(TreeNode node){
        if(node.left.left == null){
            int val = node.left.val;
            if(isLeaf(node.left)){
                node.left = null;
                return val;
            }
            deleteHelper(node.left);
            return val;
        }else{
            return getSmallest(node.left);
        }
    }

    private boolean isLeaf(TreeNode node){
        return node != null && node.left == null && node.right == null;
    }
}
