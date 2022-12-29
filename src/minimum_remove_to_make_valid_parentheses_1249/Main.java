package minimum_remove_to_make_valid_parentheses_1249;

/*
    Given a string s of '(' , ')' and lowercase English characters.

    Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

    Formally, a parentheses string is valid if and only if:

    It is the empty string, contains only lowercase characters, or
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.
 */
public class Main {
    public String minRemoveToMakeValid(String s) {
        /*
            Iterate from start to end to find invalid close parentheses
            Remove them.
            Then iterate from end to start to find invalid open parentheses
            Remove them.
         */
        StringBuilder strBd = new StringBuilder();
        // Count for available counter parentheses
        int available = 0;
        for(char ch: s.toCharArray()){
            if(ch == '(') available++;
            else if(ch == ')'){
                if(available == 0) continue;
                else available--;
            }
            strBd.append(ch);
        }
        StringBuilder strBdReverse = new StringBuilder();
        available = 0;
        for(char ch: strBd.reverse().toString().toCharArray()){
            if(ch == ')') available++;
            else if(ch == '('){
                if(available == 0) continue;
                else available--;
            }
            strBdReverse.append(ch);
        }
        return strBdReverse.reverse().toString();
    }
}
