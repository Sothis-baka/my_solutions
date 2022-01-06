package text_justification_68;

import java.util.ArrayList;
import java.util.List;

/*
    Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
    You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
    Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
    For the last line of text, it should be left-justified and no extra space is inserted between words.
 */
public class Main {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int index = 0;
        while(index < words.length){
            int available = maxWidth;
            List<String> cache = new ArrayList<>();
            while(index < words.length){
                // Stop if can't add next word
                if(cache.size() == 0){
                    if(words[index].length() > available){
                        break;
                    }
                }else{
                    // Every word needs a space
                    if(words[index].length() + 1 > available){
                        break;
                    }
                }
                cache.add(words[index]);
                // Space
                if(cache.size() != 1){
                    available--;
                }
                available -= words[index].length();
                index++;
            }
            StringBuilder strBd = new StringBuilder();
            int number = cache.size();

            // Only one word
            if(number == 1){
                strBd.append(cache.get(0));
                strBd.append(" ".repeat(available));
                result.add(strBd.toString());
                continue;
            }

            // Last line
            if(index == words.length){
                for(int i=0; i<number; i++){
                    strBd.append(cache.get(i));
                    if(i != number-1)
                        strBd.append(" ");
                }
                strBd.append(" ".repeat(maxWidth - strBd.length()));
                result.add(strBd.toString());
                continue;
            }

            int space = available / (number - 1);
            int remain = available % (number - 1);
            for(int i=0; i<number; i++){
                strBd.append(cache.get(i));
                if(i < number-1){
                    if(remain > 0){
                        strBd.append(" ".repeat(space+2));
                        remain--;
                    }else{
                        strBd.append(" ".repeat(space+1));
                    }
                }
            }
            result.add(strBd.toString());
        }

        return result;
    }

    public static void main(String[] args){
        //System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        //System.out.println(fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
        System.out.println(fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));
    }
}
