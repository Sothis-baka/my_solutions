package moving_average_from_data_stream_346;

import java.util.LinkedList;

/*
    Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 */
public class MovingAverage {
    LinkedList<Integer> cache;
    int maxSize, sum;

    public MovingAverage(int size) {
        cache = new LinkedList<>();
        maxSize = size;
        sum = 0;
    }

    public double next(int val) {
        if(cache.size() < maxSize){
            cache.offer(val);
            sum += val;
            return (double) sum / cache.size();
        }else{
            sum -= cache.removeFirst();
            sum += val;
            cache.offer(val);
            return (double) sum / maxSize;
        }
    }

    public static void main(String[] args){
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}