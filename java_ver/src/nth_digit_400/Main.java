package nth_digit_400;

/*
Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].
 */
public class Main {
    public static int findNthDigit(int n) {
        int length = 1;
        int counts = 9;

        int floor = 1;

        while (n > length * counts){
            n -= length * counts;
            length++;
            counts *= 10;
            floor *= 10;
            if(counts > 214748364){
                break;
            }
        }

        System.out.println(floor + (n - 1) / length);
        return Integer.toString(floor + (n - 1) / length).charAt((n - 1) % length) - '0';
    }

    public static void main(String[] args){
        System.out.println(findNthDigit(1000000000));
    }
}
