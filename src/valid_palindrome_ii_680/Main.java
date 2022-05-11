package valid_palindrome_ii_680;

public class Main {
    public boolean validPalindrome(String s) {
        return helper(s, 0, s.length() - 1, 1);
    }

    private boolean helper(String s, int l, int r, int chance){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                if(chance == 0) return false;

                return helper(s, l+1, r, 0) || helper(s, l, r-1, 0);
            }

            l++;
            r--;
        }

        return true;
    }
}
