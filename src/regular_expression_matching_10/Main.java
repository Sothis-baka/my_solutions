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
        if(p.isEmpty()){
            return s.isEmpty();
        }

        char cur = p.charAt(0);
        boolean escape = (cur=='.');

        if(p.length() == 1){
            if(s.length() != 1){
                return false;
            }

            return escape || s.equals(p);
        }

        if(p.charAt(1) == '*'){
            int index = -1;
            //free match
            do{
                index++;

                if(isMatch(s.substring(index), p.substring(2))){
                    return true;
                }
            }while (index < s.length() && (escape || s.charAt(index) == cur));
        }else {
            if(s.isEmpty()){
                return false;
            }

            if(escape || s.charAt(0) == cur){
                // recursive compare
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        return false;
    }
}
