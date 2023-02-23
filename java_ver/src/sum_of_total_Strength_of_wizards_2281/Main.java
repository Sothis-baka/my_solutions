package sum_of_total_Strength_of_wizards_2281;

import java.util.Arrays;
import java.util.Stack;

/*
    As the ruler of a kingdom, you have an army of wizards at your command.

    You are given a 0-indexed integer array strength, where strength[i] denotes the strength of the ith wizard. For a contiguous group of wizards (i.e. the wizards' strengths form a subarray of strength), the total strength is defined as the product of the following two values:

    The strength of the weakest wizard in the group.
    The total of all the individual strengths of the wizards in the group.
    Return the sum of the total strengths of all contiguous groups of wizards. Since the answer may be very large, return it modulo 109 + 7.

    A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class Main {
    public int totalStrength(int[] strength) {
        /*
            Sum of all continuous sub-arrays with min value

            For array [a0, a1, a2, a3, a4, a5], suppose a3 is min value
            left side:
            [
                [], [a2], [a1, a2], [a0, a1, a2]
            ],
            middle:
            a3,
            right side:
            [
                [], [a4], [a4, a5]
            ]

            min_value: a3
            sum: Sum([], [a2], [a1, a2], [a0, a1, a2]) * 1 * Size([], [a4], [a4, a5])
                + Size([], [a2], [a1, a2], [a0, a1, a2]) * a3 * Size([], [a4], [a4, a5])
                + Size([], [a2], [a1, a2], [a0, a1, a2]) * 1 * Sum([], [a4], [a4, a5])
            total: a3 * sum
        */

        // Result
        long total = 0;
        long mod = (long)Math.pow(10, 9) + 7;

        /*
            Use caches to save prefixes-sum and postfixes-sum
            forward_cache: [a0, a0+a1, a0+a1+a2, a0+a1+a2+a3]
            backward_cache: [a0+a1+a2+a3, a1+a2+a3, a2+a3, a3]
            preSum_cache: [a0+2a1+3a2+4a3, a1+2a2+3a3, a2+2a3, a3]
            postSum_cache: [a0, 2a0+a1, 3a0+2a1+a2, 4a0+3a1+2a2+a3]
        */
        // Input length
        int length = strength.length;
        // Cache to save all sub-array sum, prefixes-sum, postfixes-fum start from index 0;
        long[] forwardSum_cache = new long[length], backwardSum_cache = new long[length], preSum_cache = new long[length], postSum_cache = new long[length];
        forwardSum_cache[0] = strength[0];
        postSum_cache[0] = strength[0];
        for(int i=1; i<length; i++){
            forwardSum_cache[i] = forwardSum_cache[i-1] + strength[i];
            postSum_cache[i] = postSum_cache[i-1] + forwardSum_cache[i];
        }

        // clear
        backwardSum_cache[length - 1] = strength[length - 1];
        preSum_cache[length - 1] = strength[length - 1];
        for(int i=length - 2; i>=0; i--){
            backwardSum_cache[i] = backwardSum_cache[i+1] + strength[i];
            preSum_cache[i] = preSum_cache[i+1] + backwardSum_cache[i];
        }

        /*
            Find prefix and postfix for each value that it's the min value in array
            Iterating the array from start to end and from end to start with a stack to find them.
        */
        int[] prefixes = new int[length], postfixes = new int[length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<length; i++){
            while (!stack.isEmpty() && strength[stack.peek()] >= strength[i]){
                stack.pop();
            }

            prefixes[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for(int i=length-1; i>=0; i--){
            while (!stack.isEmpty() && strength[stack.peek()] > strength[i]){
                stack.pop();
            }

            postfixes[i] = stack.isEmpty() ? length : stack.peek();
            stack.push(i);
        }

        for(int i=0; i<length; i++){
            int preSize = i - prefixes[i], postSize = postfixes[i] - i;

            System.out.println(total);
            System.out.println((
                    (preSize == 1 || prefixes[i] == length - 1 ? 0 : (preSum_cache[prefixes[i] + 1] - preSum_cache[i] - backwardSum_cache[i] % mod * (preSize - 1) % mod)) % mod * postSize % mod
                            + strength[i] % mod * preSize % mod * postSize % mod
                            + (postSize == 1 || postfixes[i] == 0 ? 0 : (postSum_cache[postfixes[i] - 1] - postSum_cache[i] - forwardSum_cache[i] % mod * (postSize - 1) % mod)) % mod * preSize % mod
            ) % mod * strength[i] % mod);
            System.out.println();
            total +=
                    (
                            (preSize == 1 || prefixes[i] == length - 1 ? 0 : (preSum_cache[prefixes[i] + 1] - preSum_cache[i] - backwardSum_cache[i] % mod * (preSize - 1) % mod)) % mod * postSize % mod
                            + strength[i] % mod * preSize % mod * postSize % mod
                            + (postSize == 1 || postfixes[i] == 0 ? 0 : (postSum_cache[postfixes[i] - 1] - postSum_cache[i] - forwardSum_cache[i] % mod * (postSize - 1) % mod)) % mod * preSize % mod
                    ) % mod * strength[i] % mod;
            total %= mod;
        }

        return (int) total;
    }

    public static void main(String[] args){
        System.out.println(new Main().totalStrength(new int[]{1689,1159,323,348,374,303,782,1816,1455,196,749,1835,70,851,873,1546,1670,132,1438,1576,1864,1532,1816,1672,564,1427,1404,263,724,585,706,309,1869,938,1678,545,1528,1103,748,470,289,207,1197,1208,1120,678,1159,1232,1449,1208,1002,254,1627,1712,1191,1427,1958,1154,1987,1964,1264,1399,1612,52,1513,241,1117,973,1320,1306,302,692,1091,806,1435,99,1770,447,166,1933,1377,1135,25,1559,106,775,615,1455,1479,1247,266,490,1670,1525,462,1951,1070,694,658,390,517,1452,322,714,557,1965,1247,915,1385,298,1101,1409,1382,779,396,1933,1693,685,384,704,101,362,1381,964,1948,1771,1038,1253,730,621,508,1574,377,1218,494,696,695,1780,547,1083,1310,1999,535,1844,75,1184,248,1267,325,1909,772,893,693,556,1949,676,1016,1786,930,1157,1134,1535,170,786,882,1572,1810,1420,1378,142,408,1689,27,1073,1531,960,1529,5,113,302,1840,1960,1585,457,1874,1841,12,1681,1889,1732,1954,172,1787,1216,453,233,245,1676,276,1962,1989,360,1803,1605,308,1654,1850,1359,211,1474,776,1456,1951,643,1065,493,1706,1918,1437,779,1058,453}));
    }
}
