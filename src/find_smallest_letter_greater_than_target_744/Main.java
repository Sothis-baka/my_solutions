package find_smallest_letter_greater_than_target_744;

public class Main {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        if(target < letters[l] || target >= letters[r]) return letters[l];

        while(l < r){
            int mid = l + (r - l)/2;
            if(letters[mid] <= target) l = mid + 1;
            else r = mid;
        }

        return letters[r];
    }
}
