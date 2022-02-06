package maximal_rectangle_85;

import java.util.Stack;

/*
    Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 */
public class Main {
    public int maximalRectangle(char[][] matrix) {
        int height = matrix.length, width = matrix[0].length, maxArea = 0;
        int[][] cache = new int[height][width];

        for(int i=0; i<height; i++){
            // Save heights of each cell. Make them histograms
            if(i == 0){
                for(int j=0; j<width; j++){
                    cache[i][j] = matrix[i][j] - '0';
                }
            }else{
                for(int j=0; j<width; j++){
                    cache[i][j] = (matrix[i][j] == '0' ? 0 : matrix[i][j] + cache[i-1][j] - '0');
                }
            }

            maxArea = Math.max(maxArea, maxAreaInRow(cache[i]));
        }

        return maxArea;
    }

    // Calculate max area in the histogram
    private static int maxAreaInRow(int[] row){
        int length = row.length, maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<=length; i++){
            while (!stack.isEmpty() && (i == length || row[stack.peek()] >= row[i])){
                int height = row[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, height * (i - left - 1));
            }

            stack.push(i);
        }

        return maxArea;
    }
}
