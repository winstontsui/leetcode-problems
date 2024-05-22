/*
 * Leetcode 271: Encode and Decode Strings. Java. Medium.
 * O(n) runtime and O(n) space complexity, where n is all the characters in all strings in strs.
 * For encode, create a string with # of characters in front each word and a delimiter (I use '#').
 * For decode, track length of each word and use substring to add it to the final ArrayList.
 * 5/22/2024 Winston Tsui
*/

import java.util.ArrayList;
import java.util.List;

class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();

        for (String s : strs)
            ans.append(Integer.toString(s.length()) + "#" + s);
        return ans.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<String>();
        int index = 0;

        while (index < s.length()) {
            int wordlen = 0;
            int len = 0;

            while (s.charAt(index + len) != '#') {
                // Subtract '0' to get the number at that specific index, not its ASCII value.
                wordlen = wordlen * 10 + s.charAt(index + len) - '0';
                len++;
            }
            ans.add(s.substring(index + len + 1, index + len + 1 + wordlen));
            index = index + len + wordlen + 1;
        }

        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
