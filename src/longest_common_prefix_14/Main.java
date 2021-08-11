package longest_common_prefix_14;

public class Main {
    public static void main(String[] args){
        String[] strs = {"c","acc","ccc"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String temp="";

        int max = strs[0].length();
        for (int i=0; i<max; i++){
            temp = strs[0].substring(0, i+1);
            for(String str: strs){
                if(!str.startsWith(temp)){
                    return temp.substring(0, i);
                }
            }
        }

        return temp;
    }
}