package merge_similar_items_2363;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
    You are given two 2D integer arrays, items1 and items2, representing two sets of items. Each array items has the following properties:

    items[i] = [valuei, weighti] where valuei represents the value and weighti represents the weight of the ith item.
    The value of each item in items is unique.
    Return a 2D integer array ret where ret[i] = [valuei, weighti], with weighti being the sum of weights of all items with value valuei.

    Note: ret should be returned in ascending order by value.
 */
public class Main {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int[] entry: items1){
            map.put(entry[0], entry[1]);
        }

        for(int[] entry: items2){
            map.put(entry[0], map.getOrDefault(entry[0], 0) + entry[1]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            List<Integer> temp = new ArrayList<>();
            temp.add(entry.getKey());
            temp.add(entry.getValue());
            result.add(temp);
        }

        return result;
    }
}
