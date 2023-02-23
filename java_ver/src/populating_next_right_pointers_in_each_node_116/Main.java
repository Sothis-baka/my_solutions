package populating_next_right_pointers_in_each_node_116;

import structures.Node;

/*
    You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

    struct Node {
      int val;
      Node *left;
      Node *right;
      Node *next;
    }
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

    Initially, all next pointers are set to NULL.
 */
public class Main {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }

        link(root.left, root.right);
        return root;
    }

    private void link(Node left, Node right){
        if(left == null){
            return;
        }

        left.next = right;

        link(left.left, left.right);
        if(right != null){
            link(left.right, right.left);
            link(right.left, right.right);
        }

        // There is no need to set next of rightmost node to null, since the initial value is null.
    }
}
