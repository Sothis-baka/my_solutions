package number_of_digit_one_233;

/*
    Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 */
public class Main {
    public static int countDigitOne(int n) {
        int zeros = 0, copy = n;
        while (copy > 0){
            copy /= 10;
            zeros++;
        }

        // Save corresponding counts of different digits number to cache arr.
        int[] cache = new int[zeros];
        countHelper(zeros, cache);

        int sum = 0;
        copy = n;
        for(int i=0; i<zeros; i++){
            int digit = copy % 10;
            sum += cache[i] * digit;

            if(digit > 1){
                // Count 1 as leading number
                sum += Math.pow(10, i);
            }else if(digit == 1){
                sum += (n - copy * Math.pow(10, i) + 1);
            }
            copy /= 10;
        }

        return sum;
    }

    // number with n digit has cache[n-1] 1, EX: 1 digit -> 1,
    private static void countHelper(int n, int[] cache){
        int count = 0;
        for(int i=0; i<n; i++){
            cache[i] = count;
            count = count * 10 + (int)Math.pow(10, i);
        }
    }

    public static void main(String[] args){
        /*System.out.println(countDigitOne(13));
        System.out.println(countDigitOne(3));
        System.out.println(countDigitOne(0));*/
        System.out.println(countDigitOne(13));
        System.out.println(countDigitOne(10));
    }
}
