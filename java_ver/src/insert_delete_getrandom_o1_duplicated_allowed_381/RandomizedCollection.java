package insert_delete_getrandom_o1_duplicated_allowed_381;

import java.util.*;

public class RandomizedCollection {
    List<Integer> list;
    Map<Integer, LinkedList<Integer>> map;
    Random roll;

    public RandomizedCollection() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.roll = new Random();
    }

    public boolean insert(int val) {
        boolean result = !map.containsKey(val);

        this.map.computeIfAbsent(val, k -> new LinkedList<>()).add(list.size());
        this.list.add(val);

        return result;
    }

    public boolean remove(int val) {
        if(this.map.containsKey(val)){
            LinkedList<Integer> indexes = this.map.get(val);
            int index = indexes.removeLast();
            if(indexes.size() == 0){
                this.map.remove(val);
            }

            int lastIndex = this.list.size() - 1;
            if(index != lastIndex){
                int last = this.list.get(lastIndex);
                this.list.set(index, last);
                this.map.get(last).remove(Integer.valueOf(lastIndex));
                this.map.get(last).add(index);
            }

            this.list.remove(lastIndex);
            return true;
        }

        return false;
    }

    public int getRandom() {
        return this.list.get(roll.nextInt(this.list.size()));
    }

    public static void main(String[] args){
        RandomizedCollection rc = new RandomizedCollection();

        System.out.println(rc.insert(1));
        System.out.println(rc.insert(1));
        System.out.println(rc.insert(2));
        System.out.println(rc.insert(2));
        System.out.println(rc.insert(3));
        System.out.println(rc.insert(3));

        System.out.println(rc.remove(1));
        System.out.println(rc.remove(2));
        System.out.println(rc.remove(2));
        System.out.println(rc.remove(1));
        System.out.println(rc.remove(3));

        System.out.println(rc.insert(4));
        System.out.println(rc.remove(3));
        System.out.println(rc.remove(3));
        System.out.println(rc.list);
        System.out.println(rc.map);
    }
}
