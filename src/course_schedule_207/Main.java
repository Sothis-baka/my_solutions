package course_schedule_207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return true if you can finish all courses. Otherwise, return false.
 */
public class Main {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> cache = new HashMap<>();
        for(int[] temp: prerequisites){
            int key = temp[0];
            if(cache.containsKey(key)){
                cache.get(key).add(temp[1]);
            }else{
                List<Integer> newList = new ArrayList<>();
                newList.add(temp[1]);
                cache.put(key, newList);
            }
        }

        Boolean[] record = new Boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!finishHelper(cache, record, i)){
                return false;
            }
        }

        return true;
    }

    private boolean finishHelper(Map<Integer, List<Integer>> cache, Boolean[] record, int i){
        if(record[i] == null){
            // Prevent re-enter this entry
            record[i] = false;

            for(int val: cache.getOrDefault(i, new ArrayList<>())){
                if(!finishHelper(cache, record, val)){
                    return false;
                }
            }

            record[i] = true;
            return true;
        }else return record[i];
    }
}
