package decode_string_394;

/*
    Given an encoded string, return its decoded string.
    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
    You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
    Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 */
public class Main {
    public String decodeString(String s) {
        int length = s.length();

        StringBuilder strBd = new StringBuilder();
        int i = 0, times = 0;
        while(i < length){
            char cur = s.charAt(i);
            if(cur >= '0' && cur <= '9'){
                times = times * 10 + (cur - '0');
            }else if(cur == '['){
                int depth = 1, end = i + 1;
                while (depth > 0){
                    if(s.charAt(end) == '['){
                        depth++;
                    }else if(s.charAt(end) == ']'){
                        depth--;
                    }

                    end++;
                }

                strBd.append(decodeString(s.substring(i + 1, --end)).repeat(times));
                i = end;
                times = 0;
            }else{
                strBd.append(cur);
            }

            i++;
        }

        return strBd.toString();
    }
}
