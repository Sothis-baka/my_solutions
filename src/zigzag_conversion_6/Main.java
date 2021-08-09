package zigzag_conversion_6;

import java.util.ArrayList;
import java.util.List;

/*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"

    Write the code that will take a string and make this conversion given a number of rows:
    string convert(string s, int numRows);

    Input: s = "PAYPALISHIRING", numRows = 4
    Output: "PINALSIGYAHRPI"
    Explanation:
    P     I    N
    A   L S  I G
    Y A   H R
    P     I
 */
public class Main {
    public static void main(String[] args){
        String str = "A";
        System.out.println(convert(str, 3));
    }

    public static String convert(String s, int numRows) {
        // no need to continue
        if(s.length() < numRows || numRows == 1){
            return s;
        }

        // place to save chars
        List<StringBuilder> list = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            list.add(new StringBuilder());
        }

        int cur = 0, pos = 0;
        boolean isDown = true;
        while(cur < s.length()){
            list.get(pos).append(s.charAt(cur));

            cur++;

            // change direction and update position
            if(pos == numRows-1){
                pos--;
                isDown = false;
            }else if(pos == 0) {
                pos++;
                isDown = true;
            }else if(isDown){
                pos++;
            }else {
                pos--;
            }
        }

        // concat strings
        StringBuilder result = new StringBuilder();
        for(int i=0; i<numRows; i++){
            result.append(list.get(i));
        }

        return result.toString();

        /*if(numRows == 1){
            return s;
        }

        // structure to save
        ArrayList<char[]> matrix = new ArrayList<>();
        StringBuffer strBf = new StringBuffer();

        int width = 0;
        int cur = 0;

        while (cur < s.length()){
            char[] temp = new char[numRows];

            if(width % (numRows - 1) == 0){
                // full column
                for(int j=0; j<numRows; j++){
                    if(cur == s.length()){
                        break;
                    }
                    temp[j] = s.charAt(cur);
                    cur++;
                }
            }else {
                // find correct index
                temp[numRows - (cur % ((numRows - 1) * 2) - (numRows - 1)) - 1] = s.charAt(cur);
                cur++;
            }

            // save array
            matrix.add(temp);
            width++;
        }

        // use new order to construct a string
        for(int i=0; i<numRows; i++){
            for(char[] temp: matrix){
                if(temp[i] != '\u0000')
                    strBf.append(temp[i]);
            }
        }

        return strBf.toString();*/
    }
}
