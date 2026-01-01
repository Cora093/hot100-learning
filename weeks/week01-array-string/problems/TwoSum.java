import java.util.*;

public class TwoSum {
    /**
     * Two Sum
     * LeetCode 1
     * 
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if (cache.containsKey(target - currNum)) {
                res[0] = cache.get(target - currNum);
                res[1] = i;
                return res;
            }
            cache.put(currNum, i);
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        System.out.println("=== Test Case 1: Normal ===");
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Expected: [0, 1]");
        System.out.println("Actual: " + Arrays.toString(result1));
        System.out.println("Result: " + (Arrays.equals(result1, new int[]{0, 1}) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 2: Answer at end ===");
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Expected: [1, 2]");
        System.out.println("Actual: " + Arrays.toString(result2));
        System.out.println("Result: " + (Arrays.equals(result2, new int[]{1, 2}) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 3: Same elements ===");
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Expected: [0, 1]");
        System.out.println("Actual: " + Arrays.toString(result3));
        System.out.println("Result: " + (Arrays.equals(result3, new int[]{0, 1}) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 4: Negative numbers ===");
        int[] nums4 = {-1, -2, -3, -4, -5};
        int target4 = -8;
        int[] result4 = solution.twoSum(nums4, target4);
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Expected: [2, 4]");
        System.out.println("Actual: " + Arrays.toString(result4));
        System.out.println("Result: " + (Arrays.equals(result4, new int[]{2, 4}) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 5: Large array ===");
        int[] nums5 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target5 = 19;
        int[] result5 = solution.twoSum(nums5, target5);
        System.out.println("Input: nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = " + target5);
        System.out.println("Expected: [8, 9]");
        System.out.println("Actual: " + Arrays.toString(result5));
        System.out.println("Result: " + (Arrays.equals(result5, new int[]{8, 9}) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== All tests completed ===");
    }
}
