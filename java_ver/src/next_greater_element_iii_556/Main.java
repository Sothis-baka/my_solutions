package next_greater_element_iii_556;

import java.util.ArrayList;
import java.util.List;

/*
    Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
    Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
 */
public class Main {
    public static int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<>();
        int copy = n;
        while (copy > 0){
            list.add(copy % 10);
            copy /= 10;
        }
        list.sort(Integer::compareTo);

        return findHelper(0, n, list);
    }

    private static int findHelper(long curVal, int n, List<Integer> list){
        if(curVal > 2147483647) return -1;
        if(curVal > n) return (int) curVal;
        if(curVal != 0 && curVal < Integer.parseInt(Integer.toString(n).substring(0, 1 + (int)Math.log10(curVal)))) return -1;

        int length = list.size();
        for(int i=0; i<length; i++){
            if(i > 0 && list.get(i).equals(list.get(i-1))) continue;
            int digit = list.get(i);
            list.remove(i);
            int result = findHelper(curVal * 10 + digit, n, list);
            list.add(i, digit);
            if(result > 0) return result;
        }

        return -1;
    }

    public static void main(String[] args){
        System.out.println(nextGreaterElement(12));
    }
}
