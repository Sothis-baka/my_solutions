package palindromic_substrings_647;

public class Main {
    int count = 0;

    public int countSubstrings(String s) {
        int length = s.length();
        expandHelper(s, 0, 0);
        count++;

        for(int i=1; i<length; i++){
            expandHelper(s, i, i);
            count++;

            if(s.charAt(i) == s.charAt(i-1)){
                expandHelper(s, i-1, i);
                count++;
            }
        }

        return count;
    }

    private void expandHelper(String s, int start, int end){
        int length = s.length();
        while(start > 0 && end < length-1 && s.charAt(--start) == s.charAt(++end)) count++;
    }
}
