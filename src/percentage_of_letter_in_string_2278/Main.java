package percentage_of_letter_in_string_2278;

/*
    Given a string s and a character letter, return the percentage of characters in s that equal letter rounded down to the nearest whole percent.
 */
public class Main {
    public int percentageLetter(String s, char letter) {
        int length = s.length(), matched = 0, total = 0;
        for(int i=0; i<length; i++){
            if(s.charAt(i) == letter) matched++;
            total++;
        }

        return matched * 100 / total;
    }
}
