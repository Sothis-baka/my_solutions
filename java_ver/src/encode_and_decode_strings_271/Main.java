package encode_and_decode_strings_271;

import java.util.ArrayList;
import java.util.List;

/*
    Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
    strs2 in Machine 2 should be the same as strs in Machine 1.
    Implement the encode and decode methods.
 */
public class Main {
    public static String encode(List<String> strs) {
        StringBuilder strBd = new StringBuilder();
        for(String str: strs){
            strBd.append(str.length());
            strBd.append(str);
        }

        return strBd.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int index = 0, length = str.length();
        while(index < length){
            int strLength = str.charAt(index) - '0';
            result.add(str.substring(index+1, index+1+strLength));
            index += 1+strLength;
        }

        return result;
    }

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("");
        list.add("aa");
        list.add("a/");
        System.out.println(list);
        System.out.println(decode(encode(list)));
    }
}
