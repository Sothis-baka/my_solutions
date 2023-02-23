package length_of_last_word_58;

/*
    Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
    A word is a maximal substring consisting of non-space characters only.
 */
public class Main {
    public static int lengthOfLastWord(String s) {
        String str = s.trim();
        int i = str.lastIndexOf(' ');
        if(i < 0){
            return str.length();
        }else{
            return str.length() - i - 1;
        }
    }

    public static void main(String[] args){
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
        System.out.println(lengthOfLastWord("app "));
    }
}
