package com.example.solution;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testGroupAnagrams() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = Solution.groupAnagrams(input);

        // We expect 3 groups: ["eat","tea","ate"], ["tan","nat"], ["bat"]
        assertEquals(3, result.size());
    }
}
