package sum_root_to_leaf_numbers_129;

/*
    You are given the root of a binary tree containing digits from 0 to 9 only.

    Each root-to-leaf path in the tree represents a number.

    For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
    Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

    A leaf node is a node with no children.
 */
public class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
    }

    public static int sumNumbers(TreeNode root) {
        return recSum(root, 0);
    }

    public static int recSum(TreeNode node, int num){
        num *= 10;
        num += node.val;

        if(node.left == null){
            if(node.right == null){
                return num;
            }else {
                return recSum(node.right, num);
            }
        }else {
            if(node.right == null){
                return recSum(node.left, num);
            }else {
                return recSum(node.left, num) + recSum(node.right, num);
            }
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        root.left = n2;
        root.right = n3;

        System.out.println(sumNumbers(root));
    }
}
