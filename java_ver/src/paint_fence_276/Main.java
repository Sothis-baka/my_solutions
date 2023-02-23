package paint_fence_276;

public class Main {
    public int numWays(int n, int k) {
        /*
            total[i] = same[i] + diff[i]
            same[i] = diff[i-1]
            diff[i] = total[i-1] * (k-1) = (diff[i-1] + same[i-1]) * (k-1)
            total[i] = same[i] + diff[i] = diff[i] + diff[i-1] = total[i-1] * (k-1) + total[i-2] * (k-1)
         */
        if (n == 0) return 0;
        if (n == 1) return k;

        int first = k, second = k * k;
        for(int i=3; i<=n; i++) {
            int third = (first + second) * (k-1);
            first = second;
            second = third;
        }
        return second;
    }
}
