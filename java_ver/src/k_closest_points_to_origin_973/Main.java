package k_closest_points_to_origin_973;

import java.util.PriorityQueue;

/*
    Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
    The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
    You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */
public class Main {
    class Pair{
        int[] point;
        double dist;

        Pair(int[] point){
            this.point = point;
            this.dist = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> closestPoints = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));
        for(int[] point: points){
            closestPoints.offer(new Pair(point));
            if(closestPoints.size() > k) closestPoints.poll();
        }
        int[][] results = new int[k][];
        int index = 0;
        while (!closestPoints.isEmpty()){
            results[index++] = closestPoints.poll().point;
        }
        return results;
    }
}
