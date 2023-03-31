package buildings_with_and_ocean_view_1762;

import java.util.Stack;

/*
    There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.
    The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.
    Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
 */
public class Main {
    public int[] findBuildings(int[] heights) {
        /*
            Use a stack to save candidates
            When we visit a building, we remove all shorter buildings in the stack, since they are not valid any more.
         */
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexes = new Stack<>();
        for(int i=0; i<heights.length; i++){
            int height = heights[i];

            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
                indexes.pop();
            }
            stack.push(height);
            indexes.push(i);
        }

        int[] result = new int[indexes.size()];
        int index = indexes.size() - 1;
        while (!indexes.isEmpty()){
            result[index--] = indexes.pop();
        }

        return result;
    }
}
