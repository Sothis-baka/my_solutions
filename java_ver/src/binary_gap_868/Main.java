package binary_gap_868;

public class Main {
    public int binaryGap(int n) {
        int max=0;
        Integer dist = null;
        while(n != 0){
            int cur = n % 2;
            if(dist != null) dist++;
            if(cur == 1){
                if(dist != null) max = Math.max(dist, max);
                dist = 0;
            }
            n = n / 2;
        }

        return max;
    }
}
