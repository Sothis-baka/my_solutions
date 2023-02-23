package peeking_iterator_284;

import java.util.Iterator;

/*
    Design an iterator that supports the peek operation on an existing iterator in addition to the hasNext and the next operations.

    Implement the PeekingIterator class:

    PeekingIterator(Iterator<int> nums) Initializes the object with the given integer iterator iterator.
    int next() Returns the next element in the array and moves the pointer to the next element.
    boolean hasNext() Returns true if there are still elements in the array.
    int peek() Returns the next element in the array without moving the pointer.
 */
public class PeekingIterator implements Iterator<Integer>{
    Iterator<Integer> iterator;
    Integer last;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        last = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return last;
    }

    @Override
    public Integer next() {
        int temp = last;
        if(iterator.hasNext()){
            last = iterator.next();
        }else{
            last = null;
        }

        return temp;
    }

    @Override
    public boolean hasNext() {
        return last != null;
    }
}
