package sum_of_number_and_its_reverse_2443;

public class Main {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i=0; i<=num; i++){
            if(num - i == reverse(i)) return true;
        }
        return false;
    }

    private int reverse(int number){
        int val = 0;

        while (number > 0){
            val = val * 10 + number % 10;
            number /= 10;
        }

        return val;
    }
}
