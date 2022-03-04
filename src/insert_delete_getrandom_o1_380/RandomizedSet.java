package insert_delete_getrandom_o1_380;

import java.util.*;

public class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random roll;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        roll = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int size = list.size();
        if(size > 1){
            int pos = map.get(val);
            int last = list.get(size - 1);
            list.set(pos, last);
            map.put(last, pos);
        }

        list.remove(size - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(roll.nextInt(list.size()));
    }

    public static void main(String[] args){
        RandomizedSet rs = new RandomizedSet();

        System.out.println(rs.insert(1));
        System.out.println(rs.map);
        System.out.println(rs.list);
        System.out.println(rs.remove(2));
        System.out.println(rs.map);
        System.out.println(rs.list);
        System.out.println(rs.insert(2));
        System.out.println(rs.map);
        System.out.println(rs.list);
        System.out.println(rs.getRandom());
        System.out.println(rs.map);
        System.out.println(rs.list);
        System.out.println(rs.remove(1));
        System.out.println(rs.map);
        System.out.println(rs.list);
        System.out.println(rs.insert(2));
        System.out.println(rs.map);
        System.out.println(rs.list);
        System.out.println(rs.getRandom());
    }
}
