public class LongestPalindromicSubstring {
    /**
     * Longest Palindromic Substring
     * LeetCode 5
     *
     * TODO: Implement the algorithm
     */
    public String longestPalindrome(String s) {
        // TODO: Your implementation here
        return "";
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

        System.out.println("=== Test Case 1: Normal case ===");
        String s1 = "babad";
        String result1 = solution.longestPalindrome(s1);
        System.out.println("Input: s = \"babad\"");
        System.out.println("Expected: \"bab\" or \"aba\"");
        System.out.println("Actual: \"" + result1 + "\"");
        System.out.println("Result: " + (checkResult1(result1) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 2: Single character ===");
        String s2 = "cbbd";
        String result2 = solution.longestPalindrome(s2);
        System.out.println("Input: s = \"cbbd\"");
        System.out.println("Expected: \"bb\"");
        System.out.println("Actual: \"" + result2 + "\"");
        System.out.println("Result: " + (result2.equals("bb") ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 3: Empty string ===");
        String s3 = "";
        String result3 = solution.longestPalindrome(s3);
        System.out.println("Input: s = \"\"");
        System.out.println("Expected: \"\"");
        System.out.println("Actual: \"" + result3 + "\"");
        System.out.println("Result: " + (result3.isEmpty() ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 4: Single character ===");
        String s4 = "a";
        String result4 = solution.longestPalindrome(s4);
        System.out.println("Input: s = \"a\"");
        System.out.println("Expected: \"a\"");
        System.out.println("Actual: \"" + result4 + "\"");
        System.out.println("Result: " + (result4.equals("a") ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 5: All same characters ===");
        String s5 = "aaaaa";
        String result5 = solution.longestPalindrome(s5);
        System.out.println("Input: s = \"aaaaa\"");
        System.out.println("Expected: \"aaaaa\"");
        System.out.println("Actual: \"" + result5 + "\"");
        System.out.println("Result: " + (result5.equals("aaaaa") ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 6: No palindrome longer than 1 ===");
        String s6 = "abcde";
        String result6 = solution.longestPalindrome(s6);
        System.out.println("Input: s = \"abcde\"");
        System.out.println("Expected: any single character");
        System.out.println("Actual: \"" + result6 + "\"");
        System.out.println("Result: " + (checkResult6(result6) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 7: Two characters ===");
        String s7 = "ac";
        String result7 = solution.longestPalindrome(s7);
        System.out.println("Input: s = \"ac\"");
        System.out.println("Expected: \"a\" or \"c\"");
        System.out.println("Actual: \"" + result7 + "\"");
        System.out.println("Result: " + (checkResult7(result7) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 8: Two same characters ===");
        String s8 = "cc";
        String result8 = solution.longestPalindrome(s8);
        System.out.println("Input: s = \"cc\"");
        System.out.println("Expected: \"cc\"");
        System.out.println("Actual: \"" + result8 + "\"");
        System.out.println("Result: " + (result8.equals("cc") ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== All tests completed ===");
    }

    private static boolean checkResult1(String result) {
        return result.equals("bab") || result.equals("aba");
    }

    private static boolean checkResult6(String result) {
        return result.length() == 1;
    }

    private static boolean checkResult7(String result) {
        return result.equals("a") || result.equals("c");
    }
}
