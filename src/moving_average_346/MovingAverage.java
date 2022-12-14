package moving_average_346;

import java.util.LinkedList;
import java.util.Queue;

/*
    Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

    Implement the MovingAverage class:

    MovingAverage(int size) Initializes the object with the size of the window size.
    double next(int val) Returns the moving average of the last size values of the stream.
 */
public class MovingAverage {
    /*
        Use a queue to save the nums,
        when adding a new element, check if the queue is full, delete the head element if needed
     */

    private final Queue<Integer> queue;
    int size;
    double sum;

    public MovingAverage(int size) {
        assert size > 0;
        this.queue = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        if(this.queue.size() == this.size) this.sum -= this.queue.poll();
        this.queue.offer(val);
        this.sum += val;
        return sum / this.queue.size();
    }
}