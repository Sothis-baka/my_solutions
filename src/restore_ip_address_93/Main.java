package restore_ip_address_93;

import java.util.ArrayList;
import java.util.List;

/*
    A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
    For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
    Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 */
public class Main {
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        List<List<String>> cache = new ArrayList<>();
        fillMap(s, cache);
        StringBuffer cur = new StringBuffer();
        ipHelper(s, cur, 0, 0, result, cache);

        return result;
    }

    // Save possible choices at an index to the cache
    private static void fillMap(String s, List<List<String>> cache){
        int length = s.length();
        for(int i=length-1; i>=0; i--){
            List<String> temp = new ArrayList<>();

            if(s.charAt(i) == '0'){
                // 0 can't be leading number
                temp.add("0");
            }else if(i == length - 1){
                // 1 digit
                temp.add(s.substring(i));
            }else if(i == length - 2){
                // 2 digits
                temp.add(s.substring(i, i+1));
                temp.add(s.substring(i));
            }else{
                // 3 digits (if valid)
                if(Integer.parseInt(s.substring(i, i+3)) <= 255){
                    temp.add(s.substring(i, i+3));
                }
                temp.add(s.substring(i, i+2));
                temp.add(s.substring(i, i+1));
            }

            cache.add(0, temp);
        }
    }

    private static void ipHelper(String s, StringBuffer cur, int count, int index, List<String> result, List<List<String>> cache){
        int length = s.length();
        // Either one is all consumed
        if(index == length || count == 4){
            // Finished
            if(index == length && count == 4){
                result.add(cur.toString());
            }

            return;
        }

        count++;
        for(String temp: cache.get(index)){
            StringBuffer copy = new StringBuffer(cur);
            if(index != 0){
                copy.append(".");
            }

            copy.append(temp);
            ipHelper(s, copy, count, index + temp.length(), result, cache);
        }
    }

    public static void main(String[] args){
        System.out.println(restoreIpAddresses("101023"));
    }
}
