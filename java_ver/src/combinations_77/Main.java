package combinations_77;

import java.util.ArrayList;
import java.util.List;

/*
    Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
    You may return the answer in any order.
 */
public class Main {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        combineHelper(n, k, 1, cur, result);
        return result;
    }

    private static void combineHelper(int n, int k, int min, List<Integer> cur, List<List<Integer>> result){
        if(cur.size() == k){
            result.add(cur);
            return;
        }

        for(int i=min; i<=n; i++){
            List<Integer> copy = new ArrayList<>(cur);
            copy.add(i);
            combineHelper(n, k, i+1, copy, result);
        }
    }

    public static void main(String[] args){
        List<List<Integer>> result = combine(20,19);
        for(List<Integer> temp: result){
            System.out.println(temp);
        }
    }
}
