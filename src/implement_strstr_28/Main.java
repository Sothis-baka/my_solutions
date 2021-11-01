package implement_strstr_28;

/*
    Implement strStr().
    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Main {
    public static int strStr(String haystack, String needle) {
        int length1 = haystack.length();
        int length2 = needle.length();

        // If same
        if(haystack.equals(needle)){
            return 0;
        }

        // Empty needle
        if(length2 == 0){
            return 0;
        }

        char start = needle.charAt(0);

        for(int i=0; i<length1; i++){
            // Not enough length
            if(length1 - i < length2){
                break;
            }

            if(haystack.charAt(i) == start){
                boolean findIt = true;
                // Compare full string
                for(int j=0; j<needle.length(); j++){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        findIt = false;
                        break;
                    }
                }

                if(findIt){
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        System.out.println(strStr("", ""));
    }
}
