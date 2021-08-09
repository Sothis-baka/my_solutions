package palindrome_number_9;

/*
    Given an integer x, return true if x is palindrome integer.
    An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 */
public class Main {
    public static void main(String[] args){
        System.out.println(isPalindrome(-101));
    }

    public static boolean isPalindrome(int x) {
        String temp = Integer.toString(x);
        int length = temp.length();
        for(int i=0; i<length/2; i++){
            if(temp.charAt(i) != temp.charAt(length-1-i)){
                return false;
            }
        }

        return true;
    }
}
