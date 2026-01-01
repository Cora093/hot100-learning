import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    /**
     * Product of Array Except Self
     * LeetCode 238
     *
     * TODO: Implement the algorithm
     */
    public int[] productExceptSelf(int[] nums) {
        // TODO: Your implementation here
        return new int[0];
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        System.out.println("=== Test Case 1: Normal case ===");
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.println("Input: nums = [1, 2, 3, 4]");
        System.out.println("Expected: [24, 12, 8, 6]");
        System.out.println("Actual: " + Arrays.toString(result1));
        System.out.println("Result: " + (Arrays.equals(result1, new int[]{24, 12, 8, 6}) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 2: With zeros ===");
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.println("Input: nums = [-1, 1, 0, -3, 3]");
        System.out.println("Expected: [0, 0, 9, 0, 0]");
        System.out.println("Actual: " + Arrays.toString(result2));
        System.out.println("Result: " + (Arrays.equals(result2, new int[]{0, 0, 9, 0, 0}) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 3: All ones ===");
        int[] nums3 = {1, 1, 1, 1};
        int[] result3 = solution.productExceptSelf(nums3);
        System.out.println("Input: nums = [1, 1, 1, 1]");
        System.out.println("Expected: [1, 1, 1, 1]");
        System.out.println("Actual: " + Arrays.toString(result3));
        System.out.println("Result: " + (Arrays.equals(result3, new int[]{1, 1, 1, 1}) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 4: Single element ===");
        int[] nums4 = {5};
        int[] result4 = solution.productExceptSelf(nums4);
        System.out.println("Input: nums = [5]");
        System.out.println("Expected: [1]");
        System.out.println("Actual: " + Arrays.toString(result4));
        System.out.println("Result: " + (Arrays.equals(result4, new int[]{1}) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 5: Two elements ===");
        int[] nums5 = {2, 3};
        int[] result5 = solution.productExceptSelf(nums5);
        System.out.println("Input: nums = [2, 3]");
        System.out.println("Expected: [3, 2]");
        System.out.println("Actual: " + Arrays.toString(result5));
        System.out.println("Result: " + (Arrays.equals(result5, new int[]{3, 2}) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 6: With negative numbers ===");
        int[] nums6 = {1, -1, 2, -2};
        int[] result6 = solution.productExceptSelf(nums6);
        System.out.println("Input: nums = [1, -1, 2, -2]");
        System.out.println("Expected: [4, -4, 2, -2]");
        System.out.println("Actual: " + Arrays.toString(result6));
        System.out.println("Result: " + (Arrays.equals(result6, new int[]{4, -4, 2, -2}) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 7: Multiple zeros ===");
        int[] nums7 = {0, 0, 1};
        int[] result7 = solution.productExceptSelf(nums7);
        System.out.println("Input: nums = [0, 0, 1]");
        System.out.println("Expected: [0, 0, 0]");
        System.out.println("Actual: " + Arrays.toString(result7));
        System.out.println("Result: " + (Arrays.equals(result7, new int[]{0, 0, 0}) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== All tests completed ===");
    }
}
