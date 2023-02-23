package interleaving_string_97;

/*
    Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

    An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

    s = s1 + s2 + ... + sn
    t = t1 + t2 + ... + tm
    |n - m| <= 1
    The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
    Note: a + b is the concatenation of strings a and b.
 */
public class Main {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()){
            return false;
        }

        Boolean[][] cache = new Boolean[s1.length() + 1][s2.length() + 1];
        return interleaveHelper(s1, s2, s3, 0, 0, cache);
    }

    private static boolean interleaveHelper(String s1, String s2, String s3, int index1, int index2, Boolean[][] cache){
        if(cache[index1][index2] != null){
            return cache[index1][index2];
        }

        if(index1 == s1.length() && index2 == s2.length()){
            return true;
        }

        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index1 + index2)){
            boolean temp = interleaveHelper(s1, s2, s3, index1 + 1, index2, cache);
            cache[index1][index2] = temp;
            if(temp){
                return true;
            }
        }

        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index1 + index2)){
            boolean temp = interleaveHelper(s1, s2, s3, index1, index2 + 1, cache);
            cache[index1][index2] = temp;
            return temp;
        }

        cache[index1][index2] = false;
        return false;
    }

    public static void main(String[] args){
        System.out.println(isInterleave("", "", ""));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
