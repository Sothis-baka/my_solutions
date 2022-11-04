package minumum_amount_of_time_to_collect_garbage_2391;

/*
    You are given a 0-indexed array of strings garbage where garbage[i] represents the assortment of garbage at the ith house. garbage[i] consists only of the characters 'M', 'P' and 'G' representing one unit of metal, paper and glass garbage respectively. Picking up one unit of any type of garbage takes 1 minute.
    You are also given a 0-indexed integer array travel where travel[i] is the number of minutes needed to go from house i to house i + 1.
    There are three garbage trucks in the city, each responsible for picking up one type of garbage. Each garbage truck starts at house 0 and must visit each house in order; however, they do not need to visit every house.
    Only one garbage truck may be used at any given moment. While one truck is driving or picking up garbage, the other two trucks cannot do anything.
    Return the minimum number of minutes needed to pick up all the garbage.
 */
public class Main {
    public int garbageCollection(String[] garbage, int[] travel) {
        // We need to count the number of the garbage
        // And know the end index of each kind of garbage which is the distance a truck need to travel

        int total = 0;
        int lastM = 0, lastP = 0, lastG = 0;

        int length = garbage.length;
        for(int i=0; i<length; i++){
            // garbage in current index
            String g = garbage[i];
            // Each garbage cost 1 min
            total += g.length();

            if(g.contains("M")) lastM = i;
            if(g.contains("P")) lastP = i;
            if(g.contains("G")) lastG = i;
        }

        // travel index is smaller by 1
        for(int i=0; i<length - 1; i++){
            int curCount = 0;
            // Check whether each truck need to travel to this index
            if(lastM > i) curCount++;
            if(lastG > i) curCount++;
            if(lastP > i) curCount++;

            total += curCount * travel[i];
        }

        return total;
    }
}
