package pascals_triangle_118;

import structures.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
    Given an integer numRows, return the first numRows of Pascal's triangle.
    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
public class Main {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<numRows; i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);

            if(i > 0){
                List<Integer> lastRow = result.get(result.size() - 1);
                int num = lastRow.size() - 1;
                for(int j=0; j<num; j++){
                    row.add(lastRow.get(j) + lastRow.get(j+1));
                }
                row.add(1);
            }

            result.add(row);
        }

        return result;
    }
}
