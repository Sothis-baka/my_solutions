package average_of_levels_in_binary_tree_637;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        List<Long> sums = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        helper(root, 0, sums, counts);

        int size = sums.size();
        for(int i=0; i<size; i++){
            result.add(1.0 * sums.get(i) / counts.get(i));
        }
        return result;
    }

    private void helper(TreeNode root, int level, List<Long> sums, List<Integer> counts){
        if(root == null) return;

        if(sums.size() == level){
            sums.add((long)root.val);
            counts.add(1);
        }else{
            sums.set(level, sums.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        }

        helper(root.left, level + 1, sums, counts);
        helper(root.right, level + 1, sums, counts);
    }
}
