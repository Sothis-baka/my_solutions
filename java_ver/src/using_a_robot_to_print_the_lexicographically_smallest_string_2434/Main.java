package using_a_robot_to_print_the_lexicographically_smallest_string_2434;

import java.util.Stack;

/*
    You are given a string s and a robot that currently holds an empty string t. Apply one of the following operations until s and t are both empty:

    Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
    Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
    Return the lexicographically smallest string that can be written on the paper.
 */
public class Main {
    public String robotWithString(String s) {
        /*
            For a character, append it if no smaller ch is after it, otherwise save it the the stack
         */
        StringBuilder strBd = new StringBuilder();

        /*
            Count all chars
         */
        int[] counts = new int[26];
        for(char ch: s.toCharArray())
            counts[ch - 'a']++;

        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            stack.push(ch);
            counts[ch - 'a']--;

            while(!stack.isEmpty() && !containsSmaller(counts, stack.peek() - 'a'))
                strBd.append(stack.pop());
        }

        return strBd.toString();
    }

    private boolean containsSmaller(int[] counts, int charIndex){
        for(int i=0; i<charIndex; i++)
            if(counts[i] > 0) return true;

        return false;
    }
}