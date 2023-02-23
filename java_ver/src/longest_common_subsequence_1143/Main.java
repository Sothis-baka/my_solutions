package longest_common_subsequence_1143;


import java.util.Arrays;

public class Main {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length()][text2.length()];
        for(int[] row: cache) Arrays.fill(row, -1);
        return subSeqHelper(text1, text2, 0, 0, cache);
    }

    private int subSeqHelper(String str1, String str2, int index1, int index2, int[][] cache){
        if(index1 == str1.length() || index2 == str2.length()) return 0;

        // Visited
        if(cache[index1][index2] != -1) return cache[index1][index2];

        // DFS
        int max = 0;
        // Compare current chars
        if(str1.charAt(index1) == str2.charAt(index2))
            max = Math.max(max, 1 + subSeqHelper(str1, str2, index1 + 1, index2 + 1, cache));

        // Ignore this one
        max = Math.max(max, subSeqHelper(str1, str2, index1 + 1, index2, cache));
        max = Math.max(max, subSeqHelper(str1, str2, index1, index2 + 1, cache));

        // Save to cache
        cache[index1][index2] = max;
        return max;
    }

    public static void main(String[] args){
        System.out.println(new Main().longestCommonSubsequence("abc", "abc"));
    }
}
