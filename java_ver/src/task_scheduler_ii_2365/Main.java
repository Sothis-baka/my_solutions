package task_scheduler_ii_2365;

import java.util.HashMap;
import java.util.Map;

/*
    You are given a 0-indexed array of positive integers tasks, representing tasks that need to be completed in order, where tasks[i] represents the type of the ith task.

    You are also given a positive integer space, which represents the minimum number of days that must pass after the completion of a task before another task of the same type can be performed.

    Each day, until all tasks have been completed, you must either:

    Complete the next task from tasks, or
    Take a break.
    Return the minimum number of days needed to complete all tasks.
 */
public class Main {
    public long taskSchedulerII(int[] tasks, int space) {
        // Greedy search
        // Use hashmap to save previous index, wait until space is fulfilled
        Map<Integer, Long> map = new HashMap<>();

        long day = 0;
        for(int type : tasks) {
            long last = map.getOrDefault(type, (long) (- space - 1));

            if (day - last < space + 1) {
                // Wait until fulfilled
                day = last + space + 1;
            }

            map.put(type, day);
            day++;
        }

        return day;
    }
}
