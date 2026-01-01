public class BestTimeToBuyAndSellStock {
    /**
     * Best Time to Buy and Sell Stock
     * LeetCode 121
     *
     * TODO: Implement the algorithm
     */
    public int maxProfit(int[] prices) {
        // TODO: Your implementation here
        return 0;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        System.out.println("=== Test Case 1: Normal case ===");
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int result1 = solution.maxProfit(prices1);
        System.out.println("Input: prices = [7, 1, 5, 3, 6, 4]");
        System.out.println("Expected: 5");
        System.out.println("Actual: " + result1);
        System.out.println("Result: " + (result1 == 5 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 2: No profit ===");
        int[] prices2 = {7, 6, 4, 3, 1};
        int result2 = solution.maxProfit(prices2);
        System.out.println("Input: prices = [7, 6, 4, 3, 1]");
        System.out.println("Expected: 0");
        System.out.println("Actual: " + result2);
        System.out.println("Result: " + (result2 == 0 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 3: Two days ===");
        int[] prices3 = {1, 2};
        int result3 = solution.maxProfit(prices3);
        System.out.println("Input: prices = [1, 2]");
        System.out.println("Expected: 1");
        System.out.println("Actual: " + result3);
        System.out.println("Result: " + (result3 == 1 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 4: Single day ===");
        int[] prices4 = {1};
        int result4 = solution.maxProfit(prices4);
        System.out.println("Input: prices = [1]");
        System.out.println("Expected: 0");
        System.out.println("Actual: " + result4);
        System.out.println("Result: " + (result4 == 0 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 5: All same prices ===");
        int[] prices5 = {5, 5, 5, 5};
        int result5 = solution.maxProfit(prices5);
        System.out.println("Input: prices = [5, 5, 5, 5]");
        System.out.println("Expected: 0");
        System.out.println("Actual: " + result5);
        System.out.println("Result: " + (result5 == 0 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 6: Best profit at end ===");
        int[] prices6 = {3, 2, 6, 5, 0, 3};
        int result6 = solution.maxProfit(prices6);
        System.out.println("Input: prices = [3, 2, 6, 5, 0, 3]");
        System.out.println("Expected: 4");
        System.out.println("Actual: " + result6);
        System.out.println("Result: " + (result6 == 4 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 7: Large array ===");
        int[] prices7 = {7, 1, 5, 3, 6, 4, 2, 8, 1, 9};
        int result7 = solution.maxProfit(prices7);
        System.out.println("Input: prices = [7, 1, 5, 3, 6, 4, 2, 8, 1, 9]");
        System.out.println("Expected: 8");
        System.out.println("Actual: " + result7);
        System.out.println("Result: " + (result7 == 8 ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== All tests completed ===");
    }
}
