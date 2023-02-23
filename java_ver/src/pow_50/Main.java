package pow_50;

public class Main {
    public static double myPow(double x, int n) {
        // Special Cases
        if(x == 0){
            return 0;
        }

        if(x == 1){
            return 1;
        }

        if(n == 0){
            return 1;
        }

        if(n == 1){
            return x;
        }

        // Make negatives positive
        // If it's min Integer, record it
        boolean special = false;
        if(n < 0){
            if(n == -2147483648){
                special = true;
                n = 2147483647;
            }else{
                n = -n;
            }

            x = 1/x;
        }

        double[] cache = new double[31];

        cache[0] = x;
        int i = 0;

        while (i<30){
            i++;
            int p = pow2(i);
            if(p > n){
                break;
            }

            cache[i] = x * x;
            x = x * x;
        }

        n -= pow2(i - 1);

        int max = 30;
        while(n > 0){
            for(int k=max; k>=0; k--){
                int p = pow2(k);
                if(p <= n){
                    n -= p;
                    x *= cache[k];
                    max = k;
                    break;
                }
            }
        }

        if(special){
            x *= cache[0];
        }

        return x;
    }

    public static int pow2(int n){
        int result = 1;

        for(int i=0; i<n ; i++){
            result *= 2;
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(myPow(2, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2, -2));
        System.out.println(myPow(0.01, 2147483647));
    }
}
