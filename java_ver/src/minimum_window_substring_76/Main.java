package minimum_window_substring_76;

/*
    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
    The testcases will be generated such that the answer is unique.
    A substring is a contiguous sequence of characters within the string.
 */
public class Main {
    public static String minWindow(String s, String t) {
        int length = s.length();
        int lengthT = t.length();
        // t is shorter, can't find
        if(length < lengthT){
            return "";
        }

        int[] target = new int[52];
        int[] cache = new int[52];

        // Save t in target
        for(int i=0; i<lengthT; i++){
            char temp = t.charAt(i);
            if(Character.isUpperCase(temp)){
                target[26 + (temp - 'A')]++;
            }else{
                target[temp - 'a']++;
            }
        }

        // Save s to cache
        int start=0, end=0, minStart=0, minEnd=Integer.MAX_VALUE;
        for(int i=0; i<length; i++){
            // Read one letter
            char temp = s.charAt(i);
            if(Character.isUpperCase(temp)){
                cache[26 + (temp - 'A')]++;
            }else{
                cache[temp - 'a']++;
            }

            // Only compare after read enough letter
            if(i + 1 >= lengthT && contains(cache, target)){
                end = i;

                // Update start index
                char cur = s.charAt(start);
                int curIndex = Character.isUpperCase(cur) ? cur - 'A' + 26 : cur - 'a';
                while (cache[curIndex] > target[curIndex]){
                    cache[curIndex]--;
                    start++;

                    cur = s.charAt(start);
                    curIndex = Character.isUpperCase(cur) ? cur - 'A' + 26 : cur - 'a';
                }

                // Save better result
                if(end-start < minEnd-minStart){
                    minEnd = end;
                    minStart = start;
                }
            }
        }

        // Didn't find
        if(minEnd==Integer.MAX_VALUE){
            return "";
        }

        return s.substring(minStart, minEnd+1);
    }

    // Helper function to compare cache and target
    private static boolean contains(int[] a, int[] b){
        for(int i=0; i<a.length; i++){
            if(a[i] < b[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("aa", "a"));
        System.out.println(minWindow("a", "aa"));
        System.out.println(minWindow("a", "b"));
        System.out.println(minWindow("ab", "a"));
        System.out.println(minWindow("ab", "b"));
    }
}
