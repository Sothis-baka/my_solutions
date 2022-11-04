package first_letter_to_appear_twice_2351;

/*
    Given a string s consisting of lowercase English letters, return the first letter to appear twice.
 */
public class Main {
    public char repeatedCharacter(String s) {
        boolean[] cache = new boolean[26];
        for(char ch: s.toCharArray()){
            if(cache[ch - 'a']) return ch;
            else cache[ch - 'a'] = true;
        }

        return 'a';
    }
}
