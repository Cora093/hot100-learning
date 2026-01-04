import java.util.*;

public class MaxSubArray {
    /**
     * Maximum Subarray
     * LeetCode 53
     * DP Version
     */
    public int maxSubArrayDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // dp = max(dp[i-1]+num[i], num[i])
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        MaxSubArray solution = new MaxSubArray();

        System.out.println("=== Test Case 1: Normal ===");
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = solution.maxSubArrayDP(nums1);
        int expected1 = 6;
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Expected: " + expected1);
        System.out.println("Actual: " + result1);
        System.out.println("Result: " + (result1 == expected1 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 2: Single element ===");
        int[] nums2 = {1};
        int result2 = solution.maxSubArrayDP(nums2);
        int expected2 = 1;
        System.out.println("Input: nums = " + Arrays.toString(nums2));
        System.out.println("Expected: " + expected2);
        System.out.println("Actual: " + result2);
        System.out.println("Result: " + (result2 == expected2 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 3: All positive ===");
        int[] nums3 = {5, 4, -1, 7, 8};
        int result3 = solution.maxSubArrayDP(nums3);
        int expected3 = 23;
        System.out.println("Input: nums = " + Arrays.toString(nums3));
        System.out.println("Expected: " + expected3);
        System.out.println("Actual: " + result3);
        System.out.println("Result: " + (result3 == expected3 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 4: All negative ===");
        int[] nums4 = {-2, -1, -3, -4, -5};
        int result4 = solution.maxSubArrayDP(nums4);
        int expected4 = -1;
        System.out.println("Input: nums = " + Arrays.toString(nums4));
        System.out.println("Expected: " + expected4);
        System.out.println("Actual: " + result4);
        System.out.println("Result: " + (result4 == expected4 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 5: Max at middle ===");
        int[] nums5 = {-2, -3, 4, -1, -2, 1, 5, -3};
        int result5 = solution.maxSubArrayDP(nums5);
        int expected5 = 7;
        System.out.println("Input: nums = " + Arrays.toString(nums5));
        System.out.println("Expected: " + expected5);
        System.out.println("Actual: " + result5);
        System.out.println("Result: " + (result5 == expected5 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 6: DP version ===");
        int[] nums6 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result6 = solution.maxSubArrayDP(nums6);
        int expected6 = 6;
        System.out.println("Input: nums = " + Arrays.toString(nums6));
        System.out.println("Expected: " + expected6);
        System.out.println("Actual: " + result6);
        System.out.println("Result: " + (result6 == expected6 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== All tests completed ===");
    }
}
