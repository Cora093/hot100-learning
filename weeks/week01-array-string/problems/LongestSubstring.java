import java.util.*;

public class LongestSubstring {
    /**
     * Longest Substring Without Repeating Characters
     * LeetCode 3
     *
     * TODO: Implement algorithm
     */
    public int lengthOfLongestSubstring(String s) {
        // TODO: Your implementation here

        return 0;
    }

    /**
     * HashMap Version
     * TODO: Implement algorithm
     */
    public int lengthOfLongestSubstringMap(String s) {
        // TODO: Your implementation here

        return 0;
    }

    public static void main(String[] args) {
        LongestSubstring solution = new LongestSubstring();

        System.out.println("=== Test Case 1: Normal ===");
        String s1 = "abcabcbb";
        int result1 = solution.lengthOfLongestSubstring(s1);
        int expected1 = 3;
        System.out.println("Input: s = \"" + s1 + "\"");
        System.out.println("Expected: " + expected1);
        System.out.println("Actual: " + result1);
        System.out.println("Result: " + (result1 == expected1 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 2: Same character ===");
        String s2 = "bbbbb";
        int result2 = solution.lengthOfLongestSubstring(s2);
        int expected2 = 1;
        System.out.println("Input: s = \"" + s2 + "\"");
        System.out.println("Expected: " + expected2);
        System.out.println("Actual: " + result2);
        System.out.println("Result: " + (result2 == expected2 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 3: Mix ===");
        String s3 = "pwwkew";
        int result3 = solution.lengthOfLongestSubstring(s3);
        int expected3 = 3;
        System.out.println("Input: s = \"" + s3 + "\"");
        System.out.println("Expected: " + expected3);
        System.out.println("Actual: " + result3);
        System.out.println("Result: " + (result3 == expected3 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 4: Empty string ===");
        String s4 = "";
        int result4 = solution.lengthOfLongestSubstring(s4);
        int expected4 = 0;
        System.out.println("Input: s = \"" + s4 + "\"");
        System.out.println("Expected: " + expected4);
        System.out.println("Actual: " + result4);
        System.out.println("Result: " + (result4 == expected4 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 5: Single character ===");
        String s5 = "a";
        int result5 = solution.lengthOfLongestSubstring(s5);
        int expected5 = 1;
        System.out.println("Input: s = \"" + s5 + "\"");
        System.out.println("Expected: " + expected5);
        System.out.println("Actual: " + result5);
        System.out.println("Result: " + (result5 == expected5 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 6: All unique ===");
        String s6 = "abcde";
        int result6 = solution.lengthOfLongestSubstring(s6);
        int expected6 = 5;
        System.out.println("Input: s = \"" + s6 + "\"");
        System.out.println("Expected: " + expected6);
        System.out.println("Actual: " + result6);
        System.out.println("Result: " + (result6 == expected6 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 7: With spaces ===");
        String s7 = "ab ca de";
        int result7 = solution.lengthOfLongestSubstring(s7);
        int expected7 = 5;
        System.out.println("Input: s = \"" + s7 + "\"");
        System.out.println("Expected: " + expected7);
        System.out.println("Actual: " + result7);
        System.out.println("Result: " + (result7 == expected7 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 8: HashMap version ===");
        String s8 = "abcabcbb";
        int result8 = solution.lengthOfLongestSubstringMap(s8);
        int expected8 = 3;
        System.out.println("Input: s = \"" + s8 + "\"");
        System.out.println("Expected: " + expected8);
        System.out.println("Actual: " + result8);
        System.out.println("Result: " + (result8 == expected8 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== All tests completed ===");
    }
}
