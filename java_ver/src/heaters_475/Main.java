package heaters_475;

import java.util.*;

/*
    Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
    Every house can be warmed, as long as the house is within the heater's warm radius range.
    Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.
    Notice that all the heaters follow your radius standard, and the warm radius will the same.
 */
public class Main {
    public static int findRadius(int[] houses, int[] heaters) {
        int maxDist = 0;

        Arrays.sort(heaters);
        for(int house: houses){
            maxDist = Math.max(maxDist, binarySearch(house, heaters));
        }

        return maxDist;
    }

    private static int binarySearch(int val, int[] heaters){
        int l = 0, r = heaters.length - 1;
        if(heaters[l] == val || heaters[r] == val) return 0;
        if(heaters[l] > val) return heaters[l] - val;
        if(heaters[r] < val) return val - heaters[r];

        int mid;
        while(l < r - 1){
            mid = (l + r) / 2;
            if(heaters[mid] == val){
                return 0;
            }else if(heaters[mid] < val){
                l = mid;
            }else{
                r = mid;
            }
        }

        return Math.min(Math.abs(heaters[l] - val), Math.abs(heaters[r] - val));
    }

    public static void main(String[] args){
        System.out.println(findRadius(new int[]{1,2,3}, new int[]{1,2,3}));
        //System.out.println(findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
    }
}
