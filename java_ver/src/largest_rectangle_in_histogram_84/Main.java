package largest_rectangle_in_histogram_84;

import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;


// credit: NarutoBaryonMode
public class Main {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length, maxArea = 0;;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<=length; i++){
            // Consume larger nums
            while(!stack.isEmpty() && (i == length || heights[stack.peek()] >= heights[i])){
                int h = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                // column left and column i is smaller than selected column, width should be i-left-1
                maxArea = Math.max(maxArea, h * (i - left - 1));
            }

            // Save current
            stack.push(i);
        }

        return maxArea;
    }
}
