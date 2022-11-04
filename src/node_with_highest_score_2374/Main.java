package node_with_highest_score_2374;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int edgeScore(int[] edges) {
        // Greedy
        int maxScore = -1, result = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int score = map.getOrDefault(edges[i], 0) + i;
            map.put(edges[i], score);

            if(score > maxScore){
                result = edges[i];
                maxScore = score;
            }else if(score == maxScore){
                result = Math.min(result, edges[i]);
            }
        }

        return result;
    }
}
