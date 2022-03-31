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
        String str = Integer.toString(x);
        for(int l=0, r=str.length()-1; l<r; l++, r--){
            if(str.charAt(l) != str.charAt(r)) return false;
        }
        return true;
    }
}
