/*
 * Leetcode 981: Time Based Key-Value Store. Java. Medium.
 * O(log n) get operation and O(1) set operation, with O(n) space complexity.
 * Implements a time-based key-value store using a HashMap with keys mapping to lists of timestamped values.
 * Binary search is used to efficiently retrieve the most recent value at or before a given timestamp.
 * Insights: Combining a HashMap for direct key access and sorted timestamp arrays for binary search makes this approach optimal for both set and get operations.
 * 12/26/2024 Winston Tsui
 */

import java.util.*;

class TimeMap {
    // HashMap<String, ArrayList<Data>>
    // Data -> Class of -> String value
    //                  -> int timestamp
    HashMap<String, ArrayList<Data>> keyValueStore;

    static class Data {
        String value;
        int timestamp;

        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public TimeMap() {
        keyValueStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        keyValueStore.putIfAbsent(key, new ArrayList<>());
        keyValueStore.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        // Perform binary search on arraylist.
        // From l = 0 to r = list length - 1
        // If it is valid, do m = l, if not valid do r = m - 1

        if (!keyValueStore.containsKey(key))
            return "";
        ArrayList<Data> values = keyValueStore.get(key);

        int l = 0;
        int r = values.size() - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (values.get(m).timestamp <= timestamp)
                l = m + 1;
            else
                r = m - 1;
        }

        // r points to the largest timestamp ≤ given timestamp
        return r >= 0 ? values.get(r).value : "";

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
