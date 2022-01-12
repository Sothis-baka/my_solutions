package gray_code_89;

import java.util.ArrayList;
import java.util.List;

/*
    An n-bit gray code sequence is a sequence of 2n integers where:

    Every integer is in the inclusive range [0, 2n - 1],
    The first integer is 0,
    An integer appears no more than once in the sequence,
    The binary representation of every pair of adjacent integers differs by exactly one bit, and
    The binary representation of the first and last integers differs by exactly one bit.
    Given an integer n, return any valid n-bit gray code sequence.
 */
public class Main {
    public static List<Integer> grayCode(int n) {
        // Base
        if(n == 1){
            List<Integer> result = new ArrayList<>();
            result.add(0);
            result.add(1);
            return result;
        }

        // Make "0", "1" to "00", "01", "10", "11"
        List<Integer> prev = grayCode(n-1);
        int length = prev.size();
        int leading = 1<<(n-1);
        for(int i=length-1; i>=0; i--){
            prev.add(leading + prev.get(i));
        }

        return prev;
    }
}
