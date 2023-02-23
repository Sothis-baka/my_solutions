package sentence_screen_fitting_418;

/*
    Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.
 */
public class Main {
    public int wordsTyping(String[] words, int rows, int cols){
        StringBuilder strBd = new StringBuilder();
        for(String word: words){
            strBd.append(word);
        }
        String concat = strBd.toString();
        int length = concat.length();

        int start = 0;
        for(int i=0; i<rows; i++){
            start += cols;
            if(concat.charAt(start % length) == ' '){
                start++;
            }else{
                while(start > 0 && concat.charAt((start - 1)%length) != ' '){
                    start--;
                }
            }
        }

        return start / length;
    }
}