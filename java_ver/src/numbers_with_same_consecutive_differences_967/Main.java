package numbers_with_same_consecutive_differences_967;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=9; i++){
            helper(i, n - 1, k, result);
        }

        int[] arr = new int[result.size()];
        for(int i=0; i<arr.length; i++){
            arr[i] = result.get(i);
        }

        return arr;
    }

    // DFS
    private void helper(int cur, int n, int k, List<Integer> result){
        if(n == 0) {
            result.add(cur);
            return;
        }

        int last = cur % 10;


        if(k == 0) {
            helper(cur * 10 + last, n - 1, k, result);
            return;
        }

        if(last - k >= 0) helper(cur * 10 + last - k, n - 1, k, result);
        if(last + k < 10) helper(cur * 10 + last + k, n - 1, k, result);
    }
}
