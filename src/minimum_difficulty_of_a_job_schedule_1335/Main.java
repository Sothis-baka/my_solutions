package minimum_difficulty_of_a_job_schedule_1335;

import java.util.Arrays;

/*
    You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).
    You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.
    You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
    Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 */
public class Main {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int length = jobDifficulty.length;
        if (length < d) return -1;

        int[][] cache = new int[length + 1][d + 1];
        for(int[] row: cache) Arrays.fill(row, -2);
        return difficultyHelper(jobDifficulty, d, 0, cache);
    }

    /*
        DFS with 2d DP
     */
    private int difficultyHelper(int[] jobDifficulty, int d, int index, int[][] cache) {
        if(d == 0){
            // Exactly finished all the jobs
            if(index == jobDifficulty.length) return 0;
            // Not finished all the jobs
            return -1;
        }

        // No days left
        if(index == jobDifficulty.length) return -1;

        // Visited
        if(cache[index][d] != -2) return cache[index][d];

        int max = -1, minTotal = Integer.MAX_VALUE;
        for(int i = index; i < jobDifficulty.length; i++){
            max = Math.max(max, jobDifficulty[i]);
            int result = difficultyHelper(jobDifficulty, d - 1, i + 1, cache);
            if(result != -1) minTotal = Math.min(minTotal, max + result);
        }
        // Update and return
        return  cache[index][d] = minTotal == Integer.MAX_VALUE ? -1 : minTotal;
    }
}
