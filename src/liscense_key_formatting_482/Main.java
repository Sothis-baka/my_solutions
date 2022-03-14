package liscense_key_formatting_482;

import java.util.Stack;

/*
    You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.
    We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.
    Return the reformatted license key.
 */
public class Main {
    public String licenseKeyFormatting(String s, int k) {
        Stack<Character> stack = new Stack<>();
        int sLength = s.length();
        for(int i=0; i<sLength; i++){
            char ch = s.charAt(i);
            if(ch != '-'){
                stack.push(Character.toUpperCase(ch));
            }
        }

        StringBuilder strBd = new StringBuilder();
        while(stack.size() > k){
            for(int i=0; i<k; i++){
                strBd.insert(0, stack.pop());
            }
            strBd.insert(0, '-');
        }
        while(!stack.isEmpty()){
            strBd.insert(0, stack.pop());
        }
        return strBd.toString();
    }
}
