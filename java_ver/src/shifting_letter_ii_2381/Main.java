package shifting_letter_ii_2381;

/*
    You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni]. For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.

    Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').

    Return the final string after all such shifts to s are applied.
 */
public class Main {
    public String shiftingLetters(String s, int[][] shifts) {
        int length = s.length();
        int[] cache = new int[length + 1];

        for(int[] shift: shifts){
            if(shift[2] == 0){
                cache[shift[0]]--;
                cache[shift[1] + 1]++;
            }else{
                cache[shift[0]]++;
                cache[shift[1] + 1]--;
            }
        }

        StringBuilder newStr = new StringBuilder();
        int displace = 0;
        for(int i=0; i<length; i++){
            displace += cache[i];
            int newCh = (s.charAt(i) - 'a' + displace);
            newCh = newCh % 26;
            newCh = (newCh + 26) % 26;

            newStr.append((char) (newCh + 'a'));
        }
        return newStr.toString();
    }
}
