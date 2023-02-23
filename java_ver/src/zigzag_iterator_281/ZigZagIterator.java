package zigzag_iterator_281;

import java.util.ArrayList;
import java.util.List;

/*
    Given two 1d vectors, implement an iterator to return their elements alternately.For example, given two 1d vectors:
 */
public class ZigZagIterator {
    boolean on1;
    List<Integer> l1, l2;
    int index1, index2, length1, length2;

    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        this.l1 = v1;
        this.l2 = v2;
        on1 = true;
        length1 = v1.size();
        length2 = v2.size();
    }

    public int next() {
        if(on1){
            if(index1 == length1){
                on1 = false;
                return next();
            }

            on1 = false;
            return l1.get(index1++);
        }else{
            if(index2 == length2){
                on1 = true;
                return next();
            }

            on1 = true;
            return l2.get(index2++);
        }
    }

    public boolean hasNext() {
        return index1 != length1 || index2 != length2;
    }

    public static void main(String[] args){
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        int[] arr1 = {1, 2}, arr2 = {3,4, 5, 6};
        for(int temp: arr1){
            l1.add(temp);
        }
        for(int temp: arr2){
            l2.add(temp);
        }

        ZigZagIterator iter = new ZigZagIterator(l1, l2);
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
