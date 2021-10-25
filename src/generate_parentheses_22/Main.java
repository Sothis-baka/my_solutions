package generate_parentheses_22;

import java.util.ArrayList;
import java.util.List;

/*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class Main {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helpGenerate(result, "", n*2);

        return result;
    }

    /* Recursively append one char per run */
    private static void helpGenerate(List<String> list, String str, int n){
        // Invalid, stop
        if(!helpValid(str, n == 0)){
            return;
        }

        // Finished, add to list
        if(n == 0){
            list.add(str);
            return;
        }

        String left = str + "(";
        String right = str + ")";

        // Run for str with one more char
        helpGenerate(list, left, n-1);
        helpGenerate(list, right, n-1);
    }

    private static boolean helpValid(String str, boolean finished){
        int length = str.length();
        int depth = 0;

        for(int i=0; i<length; i++){
            if(str.charAt(i) == '('){
                depth++;
            }else {
                // ')' number is more than '('
                if(--depth < 0)
                    return false;
            }
        }

        // If finished, should check equality of '(' and ')'
        return !finished || depth == 0;
    }

    public static void main(String[] args){
        for (int i=0; i<9; i++)
            System.out.println(generateParenthesis(i));
    }
}
