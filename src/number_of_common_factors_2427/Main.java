package number_of_common_factors_2427;

public class Main {
    public int commonFactors(int a, int b) {
        int max = Math.max(a, b) / 2, count = 0;
        if(a == b) count++;
        for(int i=1; i <= max; i++){
            if(a % i == 0 && b % i == 0) count++;
        }

        return count;
    }
}
