package count_numbers_with_unique_digits_357;

public class Main {
    public int countNumbersWithUniqueDigits(int n) {
        int sum = 1;
        while(n > 0) sum += helper(n--);
        return sum;
    }

    private int helper(int n){
        if(n > 10) return 0;
        int sum = 9;
        int candidates = 9;
        n--;
        while(n > 0) {
            sum *= candidates--;
            n--;
        }
        return sum;
    }
}
