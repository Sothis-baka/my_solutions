package permutation_sequence_60;

import java.util.ArrayList;
import java.util.List;

/*
    The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
    By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
    Given n and k, return the kth permutation sequence.
 */
public class Main {
    public static String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();

        // Every number appear once
        List<Integer> candidates = new ArrayList<>();
        // EX: 123, 132, 213, 231, 312, 321; choice num is 2 for each leading number
        int choiceNum = 1;

        for(int i=1; i<=n; i++){
            candidates.add(i);
            choiceNum *= i;
        }

        // Count should start from 0 instead of 1
        k--;

        while (candidates.size() > 0){
            // Get leading number
            choiceNum /= n;
            result.append(candidates.remove(k/choiceNum));
            // Update
            n--;
            k %= choiceNum;
        }

        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(getPermutation(3,1));
    }
}
