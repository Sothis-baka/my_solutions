package rotate_image_48;

/*
    You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
public class Main {
    public static void rotate(int[][] matrix) {
        boolean[][] record = new boolean[matrix.length][matrix.length];

        int half = (matrix.length * matrix.length) / 2;
        for(int i=0; i<half; i++){
            if(record[i/matrix.length][i%matrix.length]){
                // Touched
                continue;
            }
            rotateOne(matrix, record, i/matrix.length, i%matrix.length, Integer.MAX_VALUE);
        }
    }

    private static void rotateOne(int[][] matrix, boolean[][] record, int x, int y, int fill){
        // Fill in
        int temp = matrix[x][y];
        matrix[x][y] = fill;
        // Record
        record[x][y] = true;
        // Back to start point
        if(temp == Integer.MAX_VALUE){
            return;
        }

        rotateOne(matrix, record, y, matrix.length-x-1, temp);
    }

    private static void printMatrix(int[][] matrix){
        for(int[] row: matrix){
            for(int temp: row){
                System.out.print(temp+",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] temp = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        rotate(temp);
        printMatrix(temp);
    }
}
