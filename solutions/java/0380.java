/*
 * Leetcode 380: Insert Delete GetRandom O(1). Java. Medium.
 * Design problem using a HashMap and ArrayList. Achieves O(1) insert, remove, and random access
 * by storing elements in an ArrayList and maintaining their indices in a HashMap.
 * Removal is optimized by swapping the target element with the last element before deletion.
 * 11/15/2024 Winston Tsui
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    // Maps val to index in arrayList
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (!map.containsKey(val)){
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)){
            int index = map.get(val);

            list.set(index, list.get(list.size()-1));
            map.put(list.get(list.size()-1), index); 

            map.remove(val);
            list.remove(list.size() - 1);
            return true;
            
        }
        return false;

    }
    
    public int getRandom() {
        int randomNum = random.nextInt(list.size());
        return list.get(randomNum);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
