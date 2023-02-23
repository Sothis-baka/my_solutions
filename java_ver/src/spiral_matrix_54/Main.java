package spiral_matrix_54;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> spiralOrder(int[][] matrix){
        int height = matrix.length;
        int width = matrix[0].length;
        int max = height * width;

        boolean[][] touched = new boolean[height][width];
        List<Integer> result = new ArrayList<>();
        // 0 -> right, 1 -> down, 2 -> left, 3 -> up
        boolean stop = false;
        int x=0, y=0, direction = 0;;
        while (result.size() < max){
            if(stop){
                // Turning, no need to record
                stop = false;
            }else{
                // Record current cell
                result.add(matrix[y][x]);
                touched[y][x] = true;
            }

            switch (direction){
                case 0:
                    if(x == width-1 || touched[y][x+1]){
                        direction = 1;
                        stop = true;
                    }else{
                        x++;
                    }
                    break;
                case 1:
                    if(y == height-1 || touched[y+1][x]){
                        direction = 2;
                        stop = true;
                    }else{
                        y++;
                    }
                    break;
                case 2:
                    if(x == 0 || touched[y][x-1]){
                        direction = 3;
                        stop = true;
                    }else{
                        x--;
                    }
                    break;
                case 3:
                    if(y == 0 || touched[y-1][x]){
                        direction = 0;
                        stop = true;
                    }else{
                        y--;
                    }
                    break;
                default:
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        List<Integer> result = spiralOrder(matrix);

        for(int temp: result){
            System.out.println(temp);
        }
    }
}
