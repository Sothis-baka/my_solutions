package regular_expression_matching_10;

/*
    Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.
    The matching should cover the entire input string (not partial).
 */
public class Main {
    public static void main(String[] args){
        System.out.println(isMatch("mississippi", "mis*is*ip*."));
    }

    public static boolean isMatch(String s, String p) {
        return matchHelper(s, p, 0, 0, new boolean[s.length()+1][p.length()+1]);
    }

    private static boolean matchHelper(String s, String p, int i1, int i2, boolean[][] cache){
        int l1 = s.length(), l2 = p.length();
        if(i1 == l1 && i2 == l2) return true;
        // Can't consume anymore
        if(i2 == l2) return false;
        // Visited
        if(i1 != l1 && cache[i1][i2]) return false;
        char ch = p.charAt(i2);
        boolean repeat = i2 + 1 < l2 && p.charAt(i2+1) == '*';
        // Skip the pattern
        if(repeat && matchHelper(s, p, i1, i2+2, cache)) return true;
        if(i1 == l1){
            cache[i1][i2] = true;
            return false;
        }

        if(ch != '.' && s.charAt(i1) != ch){
            cache[i1][i2] = true;
            return false;
        }

        if(repeat){
            if(matchHelper(s, p, i1+1, i2, cache) || matchHelper(s, p, i1+1, i2+2, cache))
                return true;
        }else{
            if(matchHelper(s, p, i1+1, i2+1, cache)) return true;
        }

        cache[i1][i2] = true;
        return false;
    }
}
