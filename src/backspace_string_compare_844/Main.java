package backspace_string_compare_844;

public class Main {
    public boolean backspaceCompare(String s, String t) {
        return toStr(s).equals(toStr(t));
    }

    private String toStr(String s){
        StringBuilder strBd = new StringBuilder();

        int length = s.length();
        for(int i=0; i<length; i++){
            char cur = s.charAt(i);
            if(cur == '#'){
                int last = strBd.length() - 1;
                if(last >= 0){
                    strBd.deleteCharAt(last);
                }
            }else strBd.append(cur);
        }

        return strBd.toString();
    }
}
