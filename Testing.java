import java.util.*;

public class Testing {
    public static void main(String[] args) {
        String word1 = "as?b?e?gf";
        String substr1 = "abc";
        System.out.println(getSmallestString(word1, substr1));
        System.out.println(getSmallestString2(word1, substr1));
    }

    private static String getSmallestString2(String word, String substr) {
        String smallestString = null;
        for (int i = 0; i <= word.length() - substr.length(); i++) {
            boolean canPlace = true;
            for (int j = 0; j < substr.length(); j++) {
                if (word.charAt(i + j) != '?' && word.charAt(i + j) != substr.charAt(j)) {
                    canPlace = false;
                    break;  // Ensure this break is inside the if-block
                }
            }
            
            if (canPlace) {
                StringBuilder temp = new StringBuilder(word);
                for (int j = 0; j < substr.length(); j++) {
                    temp.setCharAt(i + j, substr.charAt(j));
                }
                for (int j = 0; j < word.length(); j++) {
                    if (temp.charAt(j) == '?') {
                        temp.setCharAt(j, 'a');
                    }
                }
                String possibleString = temp.toString();
                if (smallestString == null || smallestString.compareTo(possibleString) > 0) {
                    smallestString = possibleString;
                }
            }
        }
        
        return smallestString == null ? "-1" : smallestString;
    }
    public static String getSmallestString(String word, String substr) {
        String smallestString = null;
        for (int i = 0; i <= word.length() - substr.length(); i++) {
            boolean canPlace = true;
            for (int j = 0; j < substr.length(); j++) {
                if (word.charAt(i + j) != '?' && word.charAt(i + j) != substr.charAt(j)) {
                    canPlace = false;
                    break;
                }
            }
            
            if (canPlace) {
                StringBuilder temp = new StringBuilder(word);
                for (int j = 0; j < substr.length(); j++) {
                    temp.setCharAt(i + j, substr.charAt(j));
                }
                for (int j = 0; j < word.length(); j++) {
                    if (temp.charAt(j) == '?')
                        temp.setCharAt(j, 'a');
                }
                String possibleString = temp.toString();
                if (smallestString == null || smallestString.compareTo(possibleString) > 0)
                    smallestString = possibleString;
            }
        }
        
        return smallestString == null ? "-1" : smallestString;
    }
    
}
