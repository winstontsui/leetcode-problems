
import java.util.*;
/*
1, 2, 3, 6, 7, 9, 11, 12, 13, 14, 15, 17, 18, 19, 20, 21, 22, 23, 24, 26, 27, 28, 31, 32, 33, 34, 37, 38, 39, 41, 42, 48, 49, 50, 51, 53, 55, 57, 61, 62, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 83, 84, 85, 88, 93, 96, 98, 100, 101, 102, 103, 104, 105, 107, 108, 109, 110, 113, 116, 117, 118, 120, 121, 128, 129, 130, 131, 133, 134, 138, 139, 141, 143, 144, 146, 150, 153, 155, 162, 167, 169, 173, 176, 179, 189, 190, 191, 198, 199, 200, 206, 207, 208, 209, 210, 211, 213, 216, 217, 224, 226, 229, 230, 232, 233, 234, 235, 236, 237, 238, 239, 240, 242, 253, 257, 266, 268, 271, 280, 286, 287, 295, 297, 322, 323, 334, 338, 344, 347, 355, 359, 373, 380, 383, 388, 389, 394, 399, 404, 417, 424, 435, 437, 442, 450, 472, 482, 494, 496, 513, 535, 542, 543, 547, 564, 567, 572, 575, 606, 621, 648, 647, 658, 661, 662, 703, 704, 703, 704, 739, 740, 743, 752, 763, 767, 778, 784, 787, 802, 815, 853, 863, 864, 876, 901, 904, 909, 933, 939, 944, 981, 986, 994, 1004, 1021, 1029, 1046, 1047, 1050, 1085, 1091, 1200, 1207, 1281, 1306, 1436, 1448, 1457, 1462, 1466, 1509, 1526, 1584, 1672, 1768, 1786, 1838, 1905, 1928, 2000, 2101, 2331, 2337, 2380, 2390, 2405, 2667, 2652, 2667, 2870, 2971, 3346, 3349, 3355



*/
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
