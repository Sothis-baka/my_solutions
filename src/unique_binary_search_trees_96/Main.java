package unique_binary_search_trees_96;

/*
    Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 */
public class Main {
    public static int numTrees(int n) {
        int[] cache = new int[n];
        return countHelper(n, cache);
    }

    private static int countHelper(int n, int[] cache){
        if(n <= 1){
            return 1;
        }

        if(cache[n-1] != 0){
            return cache[n-1];
        }

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += countHelper(i, cache) * countHelper(n-i-1, cache);
        }
        cache[n-1] = sum;
        return sum;
    }

    public static void main(String[] args){
        System.out.println(numTrees(1));
        System.out.println(numTrees(3));
        System.out.println(numTrees(5));
    }
}
