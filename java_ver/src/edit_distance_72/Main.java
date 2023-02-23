package edit_distance_72;

/*
    Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
    You have the following three operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character
 */
public class Main {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] cache = new int[l1+1][l2+1];

        for(int i=0; i<=l1; i++){
            for(int j=0; j<=l2; j++){
                if(i==0 || j==0){
                    // One String is empty
                    cache[i][j] = Math.max(i, j);
                }else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    // No need to modify
                    cache[i][j] = cache[i-1][j-1];
                }else{
                    // One modify
                    cache[i][j] = Math.min(cache[i-1][j-1], Math.min(cache[i-1][j], cache[i][j-1])) + 1;
                }
            }
        }

        return cache[l1][l2];
    }

    public static void main(String[] args){
        System.out.println(new Main().minDistance("horse", "ros"));
        System.out.println(new Main().minDistance("intention", "execution"));
        System.out.println(new Main().minDistance("zoologicoarchaeologist", "zoogeologist"));
    }
}
