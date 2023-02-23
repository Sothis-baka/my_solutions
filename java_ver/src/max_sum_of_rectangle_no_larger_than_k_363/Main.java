package max_sum_of_rectangle_no_larger_than_k_363;

/*
    Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.
    It is guaranteed that there will be a rectangle with a sum no larger than k.
 */
public class Main {
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int height = matrix.length, width = matrix[0].length;

        int[][] areasFrom0 = new int[height + 1][width + 1];

        for(int i=1; i<=height; i++){
            for(int j=1; j<=width; j++){
                areasFrom0[i][j] = areasFrom0[i][j-1] + areasFrom0[i-1][j] - areasFrom0[i-1][j-1] + matrix[i-1][j-1];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i0=0; i0<height; i0++){
            for(int j0=0; j0<width; j0++){
                for(int i1=i0+1; i1<=height; i1++){
                    for(int j1=j0+1; j1<=width; j1++){
                        int area;
                        if(i0 == 0 && j0 == 0){
                            area = areasFrom0[i1][j1];
                        }else{
                            if(i0 == 0){
                                area = areasFrom0[i1][j1] - areasFrom0[i1][j0];
                            }else if(j0 == 0){
                                area = areasFrom0[i1][j1] - areasFrom0[i0][j1];
                            }else{
                                area = areasFrom0[i1][j1] - areasFrom0[i1][j0] - areasFrom0[i0][j1] + areasFrom0[i0][j0];
                            }
                        }

                        if(area <= k){
                            if(area == k){
                                return k;
                            }
                            max = Math.max(max, area);
                        }
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args){
        int[][] matrix = {{2,2,-1}};
        System.out.println(maxSumSubmatrix(matrix, 3));
    }
}
