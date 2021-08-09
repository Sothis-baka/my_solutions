package longest_padindromic_substring_5;

/*
    Given a string s, return the longest palindromic substring in s.

    Input: s = "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
 */
public class Main {
    public static void main(String[] args){
        String str = "abadsfa";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        // no need to continue
        if(length < 2){
            return s;
        }

        String result="", temp;
        int tempLength, max=0;

        for(int i=0; i<length; i++){
            temp = tryExpand(s, i);
            tempLength = temp.length();

            if(tempLength > max){
                max = tempLength;
                result = temp;
            }
        }

        return result;
    }

    public static String tryExpand(String s, int index){
        char cur = s.charAt(index);
        int left=index, right=index, length=s.length();

        // first include all chars near and same as the current char
        while (left>=0 && s.charAt(left) == cur){
            left--;
        }
        while (right<length && s.charAt(right) == cur){
            right++;
        }

        while (left>=0 && right<length){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }

        // left, right are two chars exactly out of the string we need
        return s.substring(left+1, right);
    }
}
