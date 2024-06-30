/*
 * Leetcode 359: Logger Rate Limiter. Java. Easy.
 * O(1) runtime and O(n) space complexity.
 * All that matters is if a message be printed at time t, so check if a message has not been printed 
 * in the last 10 seconds by comparing the current timestamp with the stored timestamp.
 * 6/30/2024 Winston Tsui
*/

import java.util.HashMap;

class Logger {
    // HashMap mapping message to its timestamp.
    HashMap<String, Integer> map = new HashMap<>();

    public Logger() {
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }
        if (timestamp - map.get(message) >= 10){
            map.put(message, timestamp);
            return true;
        }
        return false;

    }
}
