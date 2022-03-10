package sequence_reconstruction_444;

import java.util.*;

/*
    Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
 */
public class Main {
    public static boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> pres = new HashMap<>();
        Map<Integer, Integer> heights = new HashMap<>();
        Set<Integer> unvisited = new HashSet<>();

        List<Integer> result = new ArrayList<>();

        for(int[] pair: seqs){
            int l = 0, r = 1;
            while(r < pair.length){
                int i = pair[l], j = pair[r];
                unvisited.add(i);
                unvisited.add(j);
                pres.computeIfAbsent(j, k -> new HashSet<>()).add(i);

                l++;
                r++;
            }
        }

        for(Set<Integer> pre: pres.values()){
            for(int temp: pre){
                heights.put(temp, heights.getOrDefault(temp, 0) + 1);
            }
        }

        while(!unvisited.isEmpty()){
            Integer candidate = null;
            for(int temp: unvisited){
                if(!heights.containsKey(temp)){
                    if(candidate == null){
                        candidate = temp;
                    }else{
                        return false;
                    }
                }
            }

            if(candidate == null){
                return false;
            }

            result.add(0, candidate);
            unvisited.remove(candidate);
            for(int pre: pres.getOrDefault(candidate, new HashSet<>())){
                if(!heights.containsKey(pre)){
                    return false;
                }

                heights.put(pre, heights.get(pre) - 1);
                if(heights.get(pre) == 0){
                    heights.remove(pre);
                }
            }
        }

        if(result.size() != org.length){
            return false;
        }

        for(int i=0; i<org.length; i++){
            if(result.get(i) != org[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        //System.out.println(sequenceReconstruction(new int[]{1,2,3}, new int[][]{{1,2}, {1,3}}));
        //System.out.println(sequenceReconstruction(new int[]{1,2,3}, new int[][]{{1,2}}));
        //System.out.println(sequenceReconstruction(new int[]{1,2,3}, new int[][]{{1,2}, {1,3}, {2,3}}));
        System.out.println(sequenceReconstruction(new int[]{4,1,5,2,6,3}, new int[][]{{5,2,6,3}, {4,1,5,2}}));
    }
}