package complete_binary_tree_inserter_919;

import structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class CBTInserter {
    TreeNode root;
    LinkedList<TreeNode> candidates;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.candidates = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null) continue;

            if(node.left == null || node.right == null) this.candidates.offer(node);
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public int insert(int val) {
        TreeNode parent = this.candidates.poll();
        if(parent.left == null){
            parent.left = new TreeNode(val);
            if(parent.right == null) candidates.addFirst(parent);
            this.candidates.offer(parent.left);
            return parent.val;
        }

        parent.right = new TreeNode(val);
        this.candidates.offer(parent.right);
        return parent.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
