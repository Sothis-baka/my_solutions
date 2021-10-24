package four_sum_18;

import java.util.*;

public class Main {
    public static void main(String[] args){
        int[] input = {2,2,2,2,2};
        int target = 8;

        System.out.println(fourSum(input, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<int[]>> twoSum = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        /*
            Key is the sum of two integers
            Value saves arrays of indexes
         */
        List<Integer> touched = new ArrayList<>();
        for(int num1: numSet) {
            for (int num2: numSet) {
                if(touched.contains(num2)){
                    continue;
                }
                int sum = num1 + num2;
                if(twoSum.containsKey(sum)) {
                    twoSum.get(sum).add(new int[]{num1, num2});
                }else {
                    List<int[]> temp = new ArrayList<>();
                    temp.add(new int[]{num1, num2});
                    twoSum.put(sum, temp);
                }
            }
            touched.add(num1);
        }

        Set<Integer> keys = twoSum.keySet();
        List<Integer> examined = new ArrayList<>();

        for(int temp: keys){
            int required = target - temp;

            if(examined.contains(required)){
                continue;
            }

            if(keys.contains(required)){
                List<int[]> li1 = twoSum.get(temp);
                List<int[]> li2 = twoSum.get(required);

                for (int[] ints1 : li1) {
                    for (int[] ints2 : li2) {
                        List<Integer> solution = new ArrayList<>();

                        solution.add(ints1[0]);
                        solution.add(ints1[1]);
                        solution.add(ints2[0]);
                        solution.add(ints2[1]);

                        if(!testSolutions(nums, solution)){
                            continue;
                        }

                        boolean repeated = false;

                        for(List<Integer> existed: result){
                            if (new HashSet<Integer>(existed).equals(new HashSet<Integer>(solution))) {
                                repeated = true;
                                break;
                            }
                        }

                        if(!repeated){
                            result.add(solution);
                        }
                    }
                }
            }

            examined.add(temp);
        }

        return result;
    }

    private static boolean testSolutions(int[] input, List<Integer> solution){
        for(int temp: solution){
            int count1 = 0;
            for(int num: solution){
                if(num == temp){
                    count1++;
                }
            }

            if(count1 > 1){
                int count2 = 0;
                for(int num: input){
                    if(num == temp){
                        count2++;
                    }
                }

                if(count2 < count1){
                    return false;
                }
            }
        }

        return true;
    }
}
