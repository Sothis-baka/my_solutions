package course_schedule_207;

import java.util.*;

/*
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return true if you can finish all courses. Otherwise, return false.
 */
public class Main {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
            Use Map<course, Set<Prerequisite>> to save all prerequisites
            Iterate though the list, save all into map
            Iterate though all the course, see if it can reach the root (no cycle)
         */

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int[] prerequisite: prerequisites){
            map.computeIfAbsent(prerequisite[1], k -> new HashSet<>()).add(prerequisite[0]);
        }

        /*
            Use an array to indicate status of a course
            0 is default value, 1 is visited, 2 is visiting
            If one meet a visiting course, it's a cycle, should return false
         */
        int[] status = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!canComplete(map, i, status)) return false;
        }

        return true;
    }

    /*
        DFS
        Helper function to see if a course is completable
     */
    private boolean canComplete(Map<Integer, Set<Integer>> prerequisites, int course, int[] status){
        // Completed check
        if(status[course] == 1) return true;
        // Visiting, it's a cycle
        if(status[course] == 2) return false;

        // Set status to visiting
        status[course] = 2;

        // Check all prerequisites
        for(int pre: prerequisites.getOrDefault(course, new HashSet<>())){
            if(!canComplete(prerequisites, pre, status)) return false;
        }

        // Mark as completed
        status[course] = 1;
        return true;
    }

    public static void main(String[] args){
        System.out.println(new Main().canFinish(3, new int[][]{{0, 2}, {1, 2}, {2, 0}}));
    }
}