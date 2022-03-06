package first_unique_character_in_a_string_387;

public class Main {
    public int firstUniqChar(String s) {
        boolean[] cache = new boolean[26];

        int length = s.length();
        for(int i=0; i<length; i++){
            char ch = s.charAt(i);
            if(!cache[ch - 'a']){
                if(s.lastIndexOf(ch) != i){
                    cache[ch - 'a'] = true;
                }else{
                    return i;
                }
            }
        }

        return -1;
    }
}
