package serialize_and_deserialize_binary_tree_297;

import structures.TreeNode;

import java.util.*;

/*
    Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
    Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 */
public class Codec {
    static String splitter = ",";
    static String nullMark = "N";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder strBd = new StringBuilder();
        serializeHelper(root, strBd);
        return strBd.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder strBd){
        if(root == null){
            strBd.append(nullMark);
            return;
        }

        strBd.append(root.val);
        strBd.append(splitter);
        serializeHelper(root.left, strBd);
        strBd.append(splitter);
        serializeHelper(root.right, strBd);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new LinkedList<>(Arrays.asList(data.split(splitter)));

        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Deque<String> queue){
        String strVal = queue.remove();
        if(strVal.equals(nullMark)){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.parseInt(strVal));
            node.left = deserializeHelper(queue);
            node.right = deserializeHelper(queue);
            return node;
        }
    }
}
