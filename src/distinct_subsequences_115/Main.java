package distinct_subsequences_115;

/*
    Given two strings s and t, return the number of distinct subsequences of s which equals t.
    A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
    The test cases are generated so that the answer fits on a 32-bit signed integer.
 */
public class Main {
    public static int numDistinct(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        int[][] cache = new int[l1+1][l2+1];

        // When l2 is empty, there should be a match
        for(int i=0; i<l1+1; i++){
            cache[i][0] = 1;
        }
        // When l1 is empty, there should be 0 match

        for(int i=1; i<l1+1; i++){
            for(int j=1; j<l2+1; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    // Current character match
                    cache[i][j] = cache[i-1][j-1] + cache[i-1][j];
                }else{
                    cache[i][j] = cache[i-1][j];
                }
            }
        }

        return cache[l1][l2];
    }

    private static void printMatrix(int[][] matrix){
        for(int[] row: matrix){
            for(int temp: row){
                System.out.print(temp);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
}
