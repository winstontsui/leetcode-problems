/*
 * Leetcode 535: Encode and Decode TinyURL. Java. Medium.
 * O(1) runtime and O(1) space complexity.
 * Use two HashMaps to store the encoded and decoded values with an integer number as the hashcode.
 * 8/6/2024 Winston Tsui
*/

import java.util.HashMap;

class Codec {
    HashMap<String, String> encodeMap = new HashMap<>();
    HashMap<String, String> decodeMap = new HashMap<>();
    int num = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (encodeMap.containsKey(longUrl))
            return encodeMap.get(longUrl);
        String newURL = String.valueOf(num++);
        encodeMap.put(longUrl, newURL);
        decodeMap.put(newURL, longUrl);
        return newURL;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
