package evaluation_division_399;

import java.util.*;

/*
    You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
    You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
    Return the answers to all queries. If a single answer cannot be determined, return -1.0.
    Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 */
public class Main {
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Double> map = new HashMap<>();
        Map<String, Set<String>> cache = new HashMap<>();
        int length = values.length, resultL = queries.size();
        for(int i=0; i<length; i++){
            List<String> equation = equations.get(i);
            String from = equation.get(0), to = equation.get(1);
            cache.computeIfAbsent(from, k->new HashSet<>()).add(to);
            cache.computeIfAbsent(to, k->new HashSet<>()).add(from);
            map.put(from + " " + to, values[i]);
        }

        double[] result = new double[resultL];
        for(int i=0; i<resultL; i++){
            List<String> equation = queries.get(i);
            result[i] = find(equation.get(0), equation.get(1), map, cache, new HashSet<>());
        }
        return result;
    }

    private static double find(String str1, String str2, Map<String, Double> map, Map<String, Set<String>> cache, Set<String> visiting){
        String pos = str1 + " " + str2, neg = str2 + " " + str1;
        if(map.containsKey(pos)){
            return map.get(pos);
        }
        if(map.containsKey(neg)){
            return 1 / map.get(neg);
        }

        if(cache.containsKey(str1)){
            visiting.add(str1);
            for(String target: cache.get(str1)){
                if(visiting.contains(target)){
                    continue;
                }

                double needed = find(target, str2, map, cache, visiting);
                if(needed != -1.0){
                    visiting.remove(str1);
                    double result = find(str1, target, map, cache, visiting) * needed;
                    cache.computeIfAbsent(str1, k->new HashSet<>()).add(str2);
                    cache.computeIfAbsent(str2, k->new HashSet<>()).add(str1);
                    map.put(pos, result);
                    return result;
                }
            }
        }

        visiting.remove(str1);
        return -1.0;
    }

    public static void main(String[] args){
        List<List<String>> equations = new ArrayList<>();
        List<String> equation1 = new ArrayList<>();
        equation1.add("a");
        equation1.add("b");
        List<String> equation2 = new ArrayList<>();
        equation2.add("b");
        equation2.add("c");

        equations.add(equation1);
        equations.add(equation2);
        double[] values = new double[]{2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> query = new ArrayList<>();
        query.add("a");
        query.add("c");
        queries.add(query);

        for(double temp: calcEquation(equations, values, queries)){
            System.out.print(temp);
        }
        System.out.println();
    }
}
