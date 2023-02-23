package course_schedule_ii_210;

import java.util.*;

/*
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */
public class Main {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] count = new int[numCourses];
        int[] result = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            map.put(i, new HashSet<>());
        }
        for(int[] temp: prerequisites){
            count[temp[0]]++;
            map.get(temp[1]).add(temp[0]);
        }

        int index = 0;
        Queue<Integer> candidates = new PriorityQueue<>();
        for(int i=0; i<numCourses; i++){
            if(count[i] == 0){
                candidates.offer(i);
            }
        }

        while(!candidates.isEmpty()){
            int cur = candidates.poll();
            result[index++] = cur;
            for(int next: map.get(cur)){
                count[next]--;
                if(count[next] == 0){
                    candidates.offer(next);
                }
            }
        }

        if(index < numCourses){
            return new int[]{};
        }

        return result;
    }
}
