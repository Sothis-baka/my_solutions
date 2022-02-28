package flatten_nested_list_iterator_341;

import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> nestedList;
    int index;
    NestedIterator nestedIter;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.index = 0;
    }

    @Override
    public Integer next() {
        if(this.nestedIter != null){
            return this.nestedIter.next();
        }

        return this.nestedList.get(index++).getInteger();
    }

    @Override
    public boolean hasNext() {
        if(this.nestedIter != null && this.nestedIter.hasNext()){
            return true;
        }

        if(index >= this.nestedList.size()){
            return false;
        }

        NestedInteger cur = this.nestedList.get(index);
        if(cur.getInteger() == null){
            this.nestedIter = new NestedIterator(cur.getList());
            index++;
            return this.hasNext();
        }else{
            this.nestedIter = null;
            return true;
        }
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
