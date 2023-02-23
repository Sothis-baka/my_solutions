package minimum_recolors_to_get_k_consecutive_black_blocks_2379;

/*
    You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.

    You are also given an integer k, which is the desired number of consecutive black blocks.

    In one operation, you can recolor a white block such that it becomes a black block.

    Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.
 */
public class Main {
    public int minimumRecolors(String blocks, int k) {
        // Sliding window

        // We are using a window of width k
        // If k contains countW white blocks
        // in current window we need countW recolors
        int left = 0, right = k, countW = 0, length = blocks.length();

        // Init status
        for(int i=0; i<k; i++){
            if(blocks.charAt(i) == 'W') countW++;
        }
        int minCount = countW;

        while (right < length){
            // Move out
            if(blocks.charAt(left++) == 'W') countW--;
            // Move in
            if(blocks.charAt(right++) == 'W') countW++;

            minCount = Math.min(minCount, countW);
        }

        return minCount;
    }
}
