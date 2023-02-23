package spiral_matrix_ii_59;

/*
    Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 */
public class Main {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        boolean[][] touched = new boolean[n][n];

        int index = 1, direction = 0, x=0, y=0;
        int totalLength = n*n;
        boolean stop = false;
        while(index <= totalLength){
            if(stop){
                // If it's stop, turn direction, continue loop
                direction = direction == 3 ? 0 : direction + 1;
                stop = false;
            }else{
                // Write current matrix
                matrix[y][x] = index;
                touched[y][x] = true;
                index++;
            }

            switch (direction){
                case 0:
                    if(x + 1 == n || touched[y][x+1]){
                        stop = true;
                        continue;
                    }
                    x++;
                    break;
                case 1:
                    if(y + 1 == n || touched[y+1][x]){
                        stop = true;
                        continue;
                    }
                    y++;
                    break;
                case 2:
                    if(x == 0 || touched[y][x-1]){
                        stop = true;
                        continue;
                    }
                    x--;
                    break;
                case 3:
                    if(y == 0 || touched[y-1][x]){
                        stop = true;
                        continue;
                    }
                    y--;
                    break;
                default:
                    break;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix){
        for(int[] row: matrix){
            for(int temp: row){
                System.out.print(temp);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        printMatrix(generateMatrix(1));
        printMatrix(generateMatrix(2));
        printMatrix(generateMatrix(3));
        printMatrix(generateMatrix(4));
    }
}
