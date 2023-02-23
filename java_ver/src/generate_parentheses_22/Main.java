package generate_parentheses_22;

import java.util.ArrayList;
import java.util.List;

/*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class Main {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(new StringBuilder(), n, 0, result);
        return result;
    }

    private static void helper(StringBuilder cur, int n, int pos, List<String> result){
        if(n == 0 && pos == 0) result.add(cur.toString());
        else{
            if(n > 0){
                cur.append('(');
                helper(cur, n-1, pos+1, result);
                cur.deleteCharAt(cur.length() - 1);
            }

            if(pos > 0){
                cur.append(')');
                helper(cur, n, pos - 1, result);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }

    public static void main(String[] args){
        for (int i=0; i<9; i++)
            System.out.println(generateParenthesis(i));
    }
}
