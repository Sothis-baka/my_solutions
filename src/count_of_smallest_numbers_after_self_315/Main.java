package count_of_smallest_numbers_after_self_315;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 */
public class Main {
    public static List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();

        List<Integer> curList = new ArrayList<>();
        for(int i=nums.length-1; i>=0; i--){
            result.addFirst(binaryInsert(nums[i], curList, 0, curList.size()));
        }
        return result;
    }

    private static int binaryInsert(int num, List<Integer> curList, int start, int end){
        if(start >= end){
            curList.add(start, num);
            return start;
        }

        int mid = start + (end - start) / 2;
        if(num <= curList.get(mid)){
            return binaryInsert(num, curList, start, mid);
        }else{
            return binaryInsert(num, curList, mid + 1, end);
        }
    }

    public static void main(String[] args){
        System.out.println(countSmaller(new int[]{5,2,6,1}));
    }

    // Test cases were updated, this solution can't pass
    /*private static class Node{
        int val, leftSize, dup = 1;
        Node left, right;

        Node(int val){
            this.val = val;
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();

        int length = nums.length;
        Node root = new Node(nums[length - 1]);
        result.addFirst(0);
        for(int i=length - 2; i>=0; i--){
            result.addFirst(insert(root, nums[i]));
        }

        return result;
    }

    protected static int insert(Node root, int newVal){
        if(newVal < root.val){
            root.leftSize++;
            if(root.left == null){
                root.left = new Node(newVal);
                return 0;
            }else{
                return insert(root.left, newVal);
            }
        }else if(newVal == root.val){
            root.dup++;
            return root.leftSize;
        }else{
            if(root.right == null){
                root.right = new Node(newVal);
                return root.leftSize + root.dup;
            }else{
                return root.leftSize + root.dup + insert(root.right, newVal);
            }
        }
    }*/

    /*public static void main(String[] args){
        int[] nums = new int[100000];
        for(int i=0; i<100000; i++){
            nums[i] = (i - 50000) / 5;
        }
        long startTime = System.nanoTime();
        countSmaller(nums);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }*/
}
