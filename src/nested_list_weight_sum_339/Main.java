package nested_list_weight_sum_339;

/*
    You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.

    The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.

    Return the sum of each integer in nestedList multiplied by its depth.
 */

import structures.NestedInteger;

import java.util.List;


public class Main {
    public int depthSum(List<NestedInteger> nestedList) {
        int total = 0;
        for(NestedInteger num: nestedList) total += depthHelper(num, 1);
        return total;
    }

    private int depthHelper(NestedInteger num, int depth){
        if(num.isInteger()) return num.getInteger() * depth;

        List<NestedInteger> list = num.getList();
        int total = 0;
        for(NestedInteger next: list) total += depthHelper(next, depth + 1);
        return total;
    }
}
