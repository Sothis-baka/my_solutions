package longest_common_prefix_14;

/*
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".
 */
public class Main {
    public static void main(String[] args){
        String[] strs = {"c","acc","ccc"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for(String str: strs){
            minLength = Math.min(minLength, str.length());
        }

        for(int i=0; i<minLength; i++){
            char ch = strs[0].charAt(i);
            for(String str: strs){
                if(str.charAt(i) != ch) return str.substring(0, i);
            }
        }

        return strs[0].substring(0, minLength);
    }
}
