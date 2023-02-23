package longest_valid_parenthesis_32;

/*
    Given a string containing just the characters '(' and ')',
    find the length of the longest valid (well-formed) parentheses substring.
 */
public class Main {
    public static int longestValidParentheses(String s) {
        int length = s.length(), max = 0, mark = 0;

        int index = 0, left = 0, right = 0;
        while (index < length){
            if(s.charAt(index) == '('){
                left++;
            }else{
                right++;
            }

            if(right > left){
                left = 0; right = 0;
                mark = index;
            }

            if(left == right){
                max = Math.max(max, left + right);
            }

            index++;
        }

        index = length - 1;
        left = 0;
        right = 0;

        while (index > mark){
            if(s.charAt(index) == '('){
                left++;
            }else{
                right++;
            }

            if(right < left){
                left = 0; right = 0;
            }

            if(left == right){
                max = Math.max(max, left + right);
            }

            index--;
        }

        return max;
    }

    public static int longestValidParentheses_oldVersion(String s) {
        int length = s.length(), max = 0;

        int left = 0;
        while(left < length){
            // If it's (, start check, read until ) is more than (.
            if (s.charAt(left) == '(') {
                int right = left + 1, count = 1, len = 0;

                while (right < length) {
                    if (s.charAt(right) == '(') {
                        count++;
                    } else {
                        count--;
                    }

                    if(count < 0){
                        // Finish checking, set pointer to left after right
                        left = right;
                        break;
                    } else{
                        if (count == 0) {
                            len = right - left + 1;
                        }

                        right++;
                    }
                }

                max = Math.max(max, len);
            }

            left++;
        }

        return max;
    }

    /*
        Problem with old version. Can't deal with situation which ( is more than ).
     */
    public static void main(String[] args){
        StringBuffer temp = new StringBuffer();
        temp.append("(".repeat(100000));
        temp.append(")".repeat(100000));

        long start = System.currentTimeMillis();
        System.out.println("Result:" + longestValidParentheses(temp.toString()));
        long end = System.currentTimeMillis();

        start = System.currentTimeMillis();
        System.out.println("Result:" + longestValidParentheses_oldVersion(temp.toString()));
        end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
