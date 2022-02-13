package find_median_from_data_stream_295;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

    For example, for arr = [2,3,4], the median is 3.
    For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
    Implement the MedianFinder class:

    MedianFinder() initializes the MedianFinder object.
    void addNum(int num) adds the integer num from the data stream to the data structure.
    double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
*/
public class MedianFinder {
    Queue<Integer> half1, half2;

    public MedianFinder() {
        half1 = new PriorityQueue<>((a, b) -> b - a);
        half2 = new PriorityQueue<>();
    }

    public void addNum(int num) {
        half2.offer(num);
        half1.offer(half2.poll());
        if(half2.size() < half1.size()){
            half2.offer(half1.poll());
        }
    }

    public double findMedian() {
        if(half1.isEmpty()){
            return 0;
        }

        if(half1.size() == half2.size()){
            return (double)(half1.peek() + half2.peek()) / 2;
        }

        return half1.peek();
    }
}
