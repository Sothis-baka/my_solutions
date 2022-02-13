package number_of_islands_ii_305;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        List<List<String>> lands = new ArrayList<>();

        for(int[] position: positions){
            int row = position[0], column = position[1];

            Queue<Integer> indexes = new PriorityQueue<>((a, b) -> (b - a));
            int size = lands.size();
            for(int i=0; i<size; i++){
                for(String neighbor: neighbors(row, column)){
                    // Record all lands connected with current cell
                    if(lands.get(i).contains(neighbor)){
                        indexes.offer(i);
                    }
                }
            }

            // Combine these lands
            List<String> newList = new ArrayList<>();
            newList.add("" + row + column);
            for(int index: indexes){
                newList.addAll(lands.remove(index));
            }
            lands.add(newList);

            result.add(lands.size());
        }

        return result;
    }

    private String[] neighbors(int r, int c){
        return new String[]{""+(r+1)+c, ""+(r-1)+c, ""+r+(c+1), ""+r+(c-1)};
    }
}
