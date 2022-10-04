package design_a_food_system_2353;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FoodRatings {
    static class FWithR{
        String food;
        int rating;
        String cuisine;

        FWithR(String food, int rating, String cuisine){
            this.food = food;
            this.rating = rating;
            this.cuisine = cuisine;
        }
    }

    Map<String, PriorityQueue<FWithR>> map;
    Map<String, FWithR> cache;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.map = new HashMap<>();
        this.cache = new HashMap<>();

        int length = foods.length;
        for(int i=0; i<length; i++){
            FWithR cur = new FWithR(foods[i], ratings[i], cuisines[i]);
            map.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>(
                    (a, b) -> a.rating == b.rating ? a.food.compareTo(b.food) : b.rating - a.rating
            )).add(cur);

            this.cache.put(foods[i], cur);
        }
    }

    public void changeRating(String food, int newRating) {
        FWithR cur = cache.get(food);
        PriorityQueue<FWithR> queue = map.get(cur.cuisine);
        queue.remove(cur);
        cur.rating = newRating;
        queue.offer(cur);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<FWithR> cur = map.get(cuisine);
        if(cur.size() == 0) return "";
        return cur.peek().food;
    }
}
