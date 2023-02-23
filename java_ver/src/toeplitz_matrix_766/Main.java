package toeplitz_matrix_766;

public class Main {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;
        for(int i=0; i<height; i++){
            int m=i, n=0, val = matrix[m][n];
            while(m < height && n < width){
                if(matrix[m][n] != val) return false;
                m++;
                n++;
            }
        }

        for(int i=1; i<width; i++){
            int m=0, n=i, val = matrix[m][n];
            while(m < height && n < width){
                if(matrix[m][n] != val) return false;
                m++;
                n++;
            }
        }

        return true;
    }
}
