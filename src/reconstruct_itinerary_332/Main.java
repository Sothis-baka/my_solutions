package reconstruct_itinerary_332;

import java.util.*;

/*
    You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

    All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

    For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
    You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
*/
public class Main {
    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> ticket: tickets){
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        findHelper("JFK", map, result);
        return result;
    }

    private static void findHelper(String cur, Map<String, PriorityQueue<String>> map, List<String> result){
        Queue<String> queue = map.getOrDefault(cur, new PriorityQueue<>());
        while(!queue.isEmpty()){
            findHelper(queue.poll(), map, result);
        }

        result.add(0, cur);
    }

    public static void main(String[] args){
        List<List<String>> li = new ArrayList<>();
        List<String> li1 = new ArrayList<>();
        li1.add("JFK");
        li1.add("SFO");
        List<String> li2 = new ArrayList<>();
        li2.add("JFK");
        li2.add("ATL");
        List<String> li3 = new ArrayList<>();
        li3.add("SFO");
        li3.add("ATL");
        List<String> li4 = new ArrayList<>();
        li4.add("ATL");
        li4.add("JFK");
        List<String> li5 = new ArrayList<>();
        li5.add("ATL");
        li5.add("SFO");
        li.add(li1);
        li.add(li2);
        li.add(li3);
        li.add(li4);
        li.add(li5);

        System.out.println(findItinerary(li));
    }
}