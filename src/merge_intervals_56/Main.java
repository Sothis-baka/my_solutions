package merge_intervals_56;

import java.util.*;

/*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class Main {
    public static int[][] merge(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] temp: intervals){
            insert(map, temp);
        }

        List<Integer> mins = new ArrayList<>(map.keySet());
        Collections.sort(mins);

        int[][] result = new int[mins.size()][];
        for(int i=0; i<mins.size(); i++){
            result[i] = new int[]{mins.get(i), map.get(mins.get(i))};
        }

        return result;
    }

    private static void insert(Map<Integer, Integer> map, int[] input){
        for(int min: map.keySet()){
            if(min >= input[0] && min <= input[1]){
                if(map.get(min) <= input[1]){
                    // [2,3], [1,4]
                    int[] temp = new int[]{input[0], input[1]};
                    map.remove(min);
                    insert(map, temp);
                    return;
                }else{
                    // [2,4], [1,3]
                    int[] temp = new int[]{input[0], map.get(min)};
                    map.remove(min);
                    insert(map, temp);
                    return;
                }
            }else if(min >= input[0] && map.get(min) <= input[1]){
                // [2,3], [1,4]
                map.remove(min);
                insert(map, input);
                return;
            }else if(min <= input[0] && map.get(min) >= input[0] && map.get(min) <= input[1]){
                // [1,3], [2,4]
                int[] temp = new int[]{min, input[1]};
                map.remove(min);
                insert(map, temp);
                return;
            }else if(min <= input[0] && map.get(min) >= input[1]){
                return;
            }
        }

        map.put(input[0], input[1]);
    }

    private static void print(int[][] matrix){
        for(int[] row: matrix){
            for(int temp: row){
                System.out.print(temp + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] result = merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});
        print(result);
    }
}
