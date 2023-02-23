package construct_string_from_binary_tree_606;

import structures.TreeNode;

public class Main {
    public String tree2str(TreeNode root) {
        if(root == null) return "";

        if(root.left == null){
            if(root.right == null) return Integer.toString(root.val);

            return root.val + "()(" + tree2str(root.right) + ")";
        }else if(root.right == null){
            return root.val + "(" + tree2str(root.left) + ")";
        }else{
            return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
        }
    }
}
