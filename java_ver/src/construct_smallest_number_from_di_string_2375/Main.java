package construct_smallest_number_from_di_string_2375;

/*
    You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.

    A 0-indexed string num of length n + 1 is created using the following conditions:

    num consists of the digits '1' to '9', where each digit is used at most once.
    If pattern[i] == 'I', then num[i] < num[i + 1].
    If pattern[i] == 'D', then num[i] > num[i + 1].
    Return the lexicographically smallest possible string num that meets the conditions.
 */
public class Main {
    public String smallestNumber(String pattern) {
        StringBuilder strBd = new StringBuilder();
        boolean[] visited = new boolean[10];

        return helper(pattern, -1, strBd, visited);
    }

    public String helper(String pattern, int index, StringBuilder strBd, boolean[] visited){
        if(index == pattern.length()){
            return strBd.toString();
        }

        String result = null;
        if(index < 0){
            for(int i=1; i<=9; i++){
                visited[i] = true;
                strBd.append(i);

                String temp = helper(pattern, index + 1, strBd, visited);
                if(temp != null){
                    if(result == null) result = temp;
                    else if(temp.compareTo(result) < 0) result = temp;
                }
                visited[i] = false;
                strBd.deleteCharAt(index + 1);
            }

            return result;
        }

        int last = strBd.charAt(index) - '0';
        if(pattern.charAt(index) == 'I'){
            for(int i=last+1; i<=9; i++){
                if(!visited[i]){
                    visited[i] = true;
                    strBd.append(i);

                    String temp = helper(pattern, index + 1, strBd, visited);
                    if(temp != null){
                        if(result == null) result = temp;
                        else if(temp.compareTo(result) < 0) result = temp;
                    }
                    visited[i] = false;
                    strBd.deleteCharAt(index + 1);
                }
            }
        }else {
            for(int i=1; i<last; i++){
                if(!visited[i]){
                    visited[i] = true;
                    strBd.append(i);

                    String temp = helper(pattern, index + 1, strBd, visited);
                    if(temp != null){
                        if(result == null) result = temp;
                        else if(temp.compareTo(result) < 0) result = temp;
                    }
                    visited[i] = false;
                    strBd.deleteCharAt(index + 1);
                }
            }
        }

        return result;
    }
}
