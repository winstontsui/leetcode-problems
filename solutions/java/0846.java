/*
 * Leetcode 846: Hand of Straights. Java. Medium.
 * O(N log N) runtime and O(N) space complexity.
 * Use a TreeMap to count frequencies and process cards in ascending order.
 * For each smallest key, attempts to "peel off" a group of `groupSize` consecutive numbers with sufficient frequency.
 *
 * Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * freqTreeMap = {
 *   1:1, 2:2, 3:2, 4:1, 6:1, 7:1, 8:1
 * }
 * Try to peel off [1,2,3], then [2,3,4], then [6,7,8]
 * All valid groups formed → return true
 *
 * 4/29/2025 Winston Tsui
 */

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        
        // Build frequency map
        TreeMap<Integer, Integer> freqTreeMap = new TreeMap<>();
        for (int num : hand)
            freqTreeMap.put(num, freqTreeMap.getOrDefault(num,0)+1);

        // Go through all entries and peel off numbers
        for (Map.Entry<Integer, Integer> entry : freqTreeMap.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            // Try to form consecutive cards here
            if (value > 0){
                for (int i = 0; i < groupSize; i++){
                    if (freqTreeMap.containsKey(key+i) && freqTreeMap.get(key+i) >= value)
                        freqTreeMap.put(key+i, freqTreeMap.get(key+i)-value);
                    else
                        return false;
                    
                    freqTreeMap.put(key, 0);
                }

            }
        }
        return true;
    }
}
