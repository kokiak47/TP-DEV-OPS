package org.example.solution;


import java.util.*;

public class Solution {

    // O(n) using frequency signature instead of sorting
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] freq = new int[26];
            for (char c : s.toCharArray())
                freq[c - 'a']++;

            String key = Arrays.toString(freq);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
