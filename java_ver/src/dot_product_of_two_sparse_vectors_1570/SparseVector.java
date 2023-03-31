package dot_product_of_two_sparse_vectors_1570;

import java.util.HashMap;
import java.util.Map;

public class SparseVector {
    Map<Integer, Integer> vector;

    SparseVector(int[] nums) {
        vector = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0) vector.put(i, nums[i]);
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;

        /*
            Only consider valid (overlapped) indexes
         */
        for(int index: vector.keySet()){
            if(vec.vector.containsKey(index)){
                result += vector.get(index) * vec.vector.get(index);
            }
        }

        return result;
    }

    public static void main(String[] args){
        SparseVector v1 = new SparseVector(new int[]{1,0,0,2,3}), v2 = new SparseVector(new int[]{0,3,0,4,0});
        System.out.println(v1.dotProduct(v2));
    }
}
