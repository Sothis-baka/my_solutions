package interval_list_intersections_986;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int l=0, r=0, lLength = firstList.length, rLength = secondList.length;

        List<int[]> result = new ArrayList<>();
        while(l < lLength && r<rLength){
            int start = Math.max(firstList[l][0], secondList[r][0]);
            int end = Math.min(firstList[l][1], secondList[r][1]);
            if(start <= end){
                result.add(new int[]{start, end});
            }
            if(firstList[l][1] < secondList[r][1]){
                l++;
            }else if(firstList[l][1] > secondList[r][1]){
                r++;
            }else{
                l++;
                r++;
            }
        }

        int[][] answer = new int[result.size()][];
        int index = 0;
        for(int[] temp: result) answer[index++] = temp;
        return answer;
    }
}
