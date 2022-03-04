package kth_smallest_element_in_a_sorted_matrix_378;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public int kthSmallest(int[][] matrix, int k) {
        int height = matrix.length, width = matrix[0].length;

        Queue<int[]> queue = new PriorityQueue<>(
                (a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]
        );

        for(int i=0; i<height; i++){
            queue.offer(new int[]{i, 0});
        }

        while(k-- > 1 && !queue.isEmpty()){
            int[] pos = queue.poll();
            if(pos[1] + 1 < width)
                queue.offer(new int[]{pos[0], pos[1] + 1});
        }

        int[] pos = queue.poll();
        return matrix[pos[0]][pos[1]];
    }
}
