package prime_number_of_set_bits_in_binary_representation_762;

public class Main {
    public int countPrimeSetBits(int left, int right) {
        boolean[] cache = new boolean[32];
        int[] primes = new int[]{2,3,5,7,11,13,17,19,23,29,31};
        for(int prime: primes){
            cache[prime] = true;
        }

        int ans = 0;
        for(int i=left; i<=right; i++){
            int num = i, count = 0;
            while(num > 0){
                num -= num & -num;
                count++;
            }
            if(cache[count]) ans++;
        }

        return ans;
    }
}
