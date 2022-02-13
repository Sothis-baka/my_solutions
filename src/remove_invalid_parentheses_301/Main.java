package remove_invalid_parentheses_301;

import java.util.*;

/*
    Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
    Return all the possible results. You may return the answer in any order.
 */
public class Main {
    public static List<String> removeInvalidParentheses(String s) {
        char[] chs = s.toCharArray();
        Set<String> result = new HashSet<>();
        int[] maxL = {0};

        validHelper(chs,0, maxL, result);
        return new ArrayList<>(result);
    }

    private static void validHelper(char[] chs, int index, int[] maxL, Set<String> result){
        int length = chs.length;
        if(index > length){
            return;
        }

        int strLength = chsL(chs);
        if(strLength < maxL[0]){
            // No need to continue
            return;
        }

        if(isValid(chs)){
            StringBuilder strBd = new StringBuilder();
            for(char ch: chs){
                if(ch != '\0'){
                    strBd.append(ch);
                }
            }

            // Discard all result worse than current
            if(strLength > maxL[0]){
                maxL[0] = strLength;
                result.clear();
            }

            result.add(strBd.toString());
            return;
        }

        for(int i=index; i<length; i++){
            char cur = chs[i];
            if(cur == '(' || cur == ')'){
                chs[i] = '\0';
                validHelper(chs, i+1, maxL, result);
                chs[i] = cur;
            }
        }
    }

    private static int chsL(char[] chs){
        int count = 0;
        for(char ch: chs){
            if(ch != '\0'){
                count++;
            }
        }
        return count;
    }

    private static boolean isValid(char[] chs){
        int count = 0;
        for (char ch : chs) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                if (--count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }

    public static void main(String[] args){
        System.out.println(removeInvalidParentheses("()())()"));
        System.out.println(removeInvalidParentheses("(a)())()"));
        System.out.println(removeInvalidParentheses(")("));
        System.out.println(removeInvalidParentheses("n"));
    }
}
