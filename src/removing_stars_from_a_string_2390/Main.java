package removing_stars_from_a_string_2390;

/*
    You are given a string s, which contains stars *.

    In one operation, you can:

    Choose a star in s.
    Remove the closest non-star character to its left, as well as remove the star itself.
    Return the string after all stars have been removed.
 */
public class Main {
    public String removeStars(String s) {
        StringBuilder strBd = new StringBuilder();
        int count = 0;

        // Read from end to start, each start can ignore a non-star character
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);

            if(s.charAt(i) == '*') count++;
            else if(count == 0) strBd.append(ch);
            else count--;
        }

        return strBd.reverse().toString();
    }
}
