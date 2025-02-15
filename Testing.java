
import java.util.*;

public class Testing {

    public static void main(String[] args) {
        System.out.println(findLongestLength("abadgdg"));
    }

    public static int findLongestLength(String fullString) {
        int n = fullString.length();
        if (n <= 1) {
            return 0;

        }
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : fullString.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> windowMap = new HashMap<>();
            for (int j = i; j < n; j++) {
                char currentChar = fullString.charAt(j);
                windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);
                boolean isSelfSufficient = true;
                for (char key : windowMap.keySet()) {
                    if (windowMap.get(key) != freqMap.get(key)) {
                        isSelfSufficient = false;
                        break;
                    }
                }
                if (isSelfSufficient && (j - i + 1) < n) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

}
