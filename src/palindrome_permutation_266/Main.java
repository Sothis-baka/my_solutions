package palindrome_permutation_266;

/*
    Given a string, determine if a permutation of the string could form a palindrome.
    For example, "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class Main {
    public static boolean canPermutePalindrome(String s) {
        int[] cache = new int[26];

        int length = s.length();
        for(int i=0; i<length; i++){
            cache[s.charAt(i) - 'a']++;
        }

        boolean findSolo = false;
        for(int i=0; i<26; i++){
            if(cache[i] % 2 == 1){
                if(findSolo){
                    return false;
                }else{
                    findSolo = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(canPermutePalindrome("code"));
        System.out.println(canPermutePalindrome("aab"));
        System.out.println(canPermutePalindrome("carerac"));
    }
}
