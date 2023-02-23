package minimum_add_to_make_parenthesis_valid_921;

public class Main {
    public int minAddToMakeValid(String s) {
        int length = s.length(), count = 0, level = 0;
        for(int i=0; i<length; i++){
            if(s.charAt(i) == '(') level++;
            else if(s.charAt(i) == ')'){
                level--;
                if(level < 0){
                    count++;
                    level = 0;
                }
            }
        }

        return count + level;
    }
}
