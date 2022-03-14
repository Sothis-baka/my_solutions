package serialize_and_deserialize_BST_449;

import structures.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/*
    Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
    Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
    The encoded string should be as compact as possible.
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder strBd = new StringBuilder();
        serializeHelper(root, strBd);
        return strBd.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder strBd){
        if(!strBd.isEmpty()){
            strBd.append(' ');
        }
        if(root == null){
            strBd.append("null");
            return;
        }
        strBd.append(root.val);
        serializeHelper(root.left, strBd);
        serializeHelper(root.right, strBd);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(" ")));
        return deserializeHelper(list);
    }

    private TreeNode deserializeHelper(LinkedList<String> list){
        if(list.isEmpty()){
            return null;
        }

        String cur = list.pop();
        if(cur.equals("null")){
            return null;
        }
        return new TreeNode(Integer.parseInt(cur), deserializeHelper(list), deserializeHelper(list));
    }
}
