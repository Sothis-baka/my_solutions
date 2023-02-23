package frog_jump_403;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

    Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

    If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
 */
public class Main {
        public boolean canCross(int[] stones) {
            Map<Integer, Set<Integer>> cache = new HashMap<>();

            for(int stone: stones){
                cache.put(stone, new HashSet<>());
            }

            return helper(0, 1, stones, cache);
        }

        private boolean helper(int index, int jump, int[] stones, Map<Integer, Set<Integer>> cache){
            int cur = index + jump;
            if(cur == stones[stones.length - 1]){
                // Arrived
                return true;
            }

            // Not a stone or visited
            if(!cache.containsKey(cur) || cache.get(index).contains(jump))
                return false;

            // Save to cache
            cache.get(index).add(jump);
            // Shouldn't jump 0
            return (jump > 1 && helper(cur, jump - 1, stones, cache)) || helper(cur, jump, stones, cache) || helper(cur, jump + 1, stones, cache);
        }
}
