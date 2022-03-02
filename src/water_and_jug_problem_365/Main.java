package water_and_jug_problem_365;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    You are given two jugs with capacities jug1Capacity and jug2Capacity liters. There is an infinite amount of water supply available. Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.

    If targetCapacity liters of water are measurable, you must have targetCapacity liters of water contained within one or both buckets by the end.

    Operations allowed:

    Fill any of the jugs with water.
    Empty any of the jugs.
    Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
*/
public class Main {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Map<Integer, Set<Integer>> cache = new HashMap<>();

        return search(0, 0, jug1Capacity, jug2Capacity, targetCapacity, cache);
    }

    private boolean search(int j1, int j2, int j1Cap, int j2Cap, int target, Map<Integer, Set<Integer>> cache){
        if(cache.computeIfAbsent(j1, k -> new HashSet<>()).contains(j2)){
            return false;
        }

        cache.get(j1).add(j2);

        if(j1 == target || j2 == target || j1 + j2 == target){
            return true;
        }

        if(search(0, j2, j1Cap, j2Cap, target, cache)){
            return true;
        }


        if(search(j1, 0, j1Cap, j2Cap, target, cache)){
            return true;
        }


        if(search(j1Cap, j2, j1Cap, j2Cap, target, cache)){
            return true;
        }


        if(search(j1, j2Cap, j1Cap, j2Cap, target, cache)){
            return true;
        }

        int sum = j1 + j2;

        if(sum > j1Cap){
            if(search(j1Cap, sum - j1Cap, j1Cap, j2Cap, target, cache)){
                return true;
            }
        }else{
            if(search(sum, 0, j1Cap, j2Cap, target, cache)){
                return true;
            }
        }

        if(sum > j2Cap){
            return search(sum - j2Cap, j2Cap, j1Cap, j2Cap, target, cache);
        }else {
            return search(0, sum, j1Cap, j2Cap, target, cache);
        }
    }
}
