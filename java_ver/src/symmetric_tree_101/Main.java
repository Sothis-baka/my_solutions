package symmetric_tree_101;

public class Main {
    private static class TreeNode {
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

    public boolean isSymmetric(TreeNode root) {
        return areSymmetric(root.left, root.right);
    }

    private boolean areSymmetric(TreeNode node1, TreeNode node2){
        if(node1 == null || node2 == null){
            return node1 == null && node2 == null;
        }

        return node1.val == node2.val && areSymmetric(node1.left, node2.right) && areSymmetric(node1.right, node2.left);
    }
}
