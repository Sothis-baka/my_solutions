package number_of_boomerangs_447;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    You are given n points in the plane that are all distinct, where points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
    Return the number of boomerangs.
 */
public class Main {
    public int numberOfBoomerangs(int[][] points) {
        int num = 0;
        Map<Integer, Integer> counts = new HashMap<>();

        int pointNum = points.length;
        for(int i=0; i<pointNum; i++){
            for(int j=0; j<pointNum; j++){
                int x = points[j][1] - points[i][1], y = points[j][0] - points[i][0];
                int distance = x * x + y * y;
                counts.put(distance, counts.getOrDefault(distance, 0) + 1);
            }

            for(int count: counts.values()){
                if(count > 1){
                    num += count * (count - 1);
                }
            }
            counts.clear();
        }

        return num;
    }
}
