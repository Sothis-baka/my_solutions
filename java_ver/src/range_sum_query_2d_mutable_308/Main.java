package range_sum_query_2d_mutable_308;

public class Main {
    /*
        Others are the same as 304
     */
    int nums[][];
    int cache[][];

    public void update(int row, int col, int val) {
        int diff = val - nums[row][col];
        nums[row][col] = val;

        for(int i=row+1; i<nums.length; i++){
            for(int j=col+1; j<nums[0].length; j++){
                cache[i][j] += diff;
            }
        }
    }
}