import java.util.*;

public class ContainsDuplicate {
    /**
     * Contains Duplicate
     * LeetCode 217
     *
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        System.out.println("=== Test Case 1: Has duplicate ===");
        int[] nums1 = {1, 2, 3, 1};
        boolean result1 = solution.containsDuplicate(nums1);
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Expected: true");
        System.out.println("Actual: " + result1);
        System.out.println("Result: " + (result1 == true ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 2: No duplicate ===");
        int[] nums2 = {1, 2, 3, 4};
        boolean result2 = solution.containsDuplicate(nums2);
        System.out.println("Input: nums = " + Arrays.toString(nums2));
        System.out.println("Expected: false");
        System.out.println("Actual: " + result2);
        System.out.println("Result: " + (result2 == false ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 3: All same elements ===");
        int[] nums3 = {1, 1, 1, 1};
        boolean result3 = solution.containsDuplicate(nums3);
        System.out.println("Input: nums = " + Arrays.toString(nums3));
        System.out.println("Expected: true");
        System.out.println("Actual: " + result3);
        System.out.println("Result: " + (result3 == true ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 4: Single element ===");
        int[] nums4 = {1};
        boolean result4 = solution.containsDuplicate(nums4);
        System.out.println("Input: nums = " + Arrays.toString(nums4));
        System.out.println("Expected: false");
        System.out.println("Actual: " + result4);
        System.out.println("Result: " + (result4 == false ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 5: Large array without duplicate ===");
        int[] nums5 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean result5 = solution.containsDuplicate(nums5);
        System.out.println("Input: nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
        System.out.println("Expected: false");
        System.out.println("Actual: " + result5);
        System.out.println("Result: " + (result5 == false ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 6: Negative numbers ===");
        int[] nums6 = {-1, -2, -3, -1};
        boolean result6 = solution.containsDuplicate(nums6);
        System.out.println("Input: nums = " + Arrays.toString(nums6));
        System.out.println("Expected: true");
        System.out.println("Actual: " + result6);
        System.out.println("Result: " + (result6 == true ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== All tests completed ===");
    }
}
