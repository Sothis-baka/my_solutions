package palindrome_permutation_266;

/*
    Given a string, determine if a permutation of the string could form a palindrome.
    For example, "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class Main {
    public boolean canPermutePalindrome(String s) {
        int mask = 0;
        for(char ch: s.toCharArray()){
            mask ^= (1 << (ch - 'a'));
        }

        return Integer.bitCount(mask) <= 1;
    }
}
