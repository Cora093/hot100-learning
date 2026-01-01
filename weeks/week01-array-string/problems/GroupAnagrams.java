import java.util.*;

public class GroupAnagrams {
    /**
     * Group Anagrams
     * LeetCode 49
     *
     * TODO: Implement the algorithm
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // TODO: Your implementation here
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        System.out.println("=== Test Case 1: Normal case ===");
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = solution.groupAnagrams(strs1);
        System.out.println("Input: strs = [\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"]");
        System.out.println("Expected: [[\"bat\"], [\"nat\", \"tan\"], [\"ate\", \"eat\", \"tea\"]]");
        System.out.println("Actual: " + result1);
        System.out.println("Result: " + (checkResult1(result1) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 2: Empty array ===");
        String[] strs2 = {};
        List<List<String>> result2 = solution.groupAnagrams(strs2);
        System.out.println("Input: strs = []");
        System.out.println("Expected: []");
        System.out.println("Actual: " + result2);
        System.out.println("Result: " + (result2.isEmpty() ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 3: Single element ===");
        String[] strs3 = {"a"};
        List<List<String>> result3 = solution.groupAnagrams(strs3);
        System.out.println("Input: strs = [\"a\"]");
        System.out.println("Expected: [[\"a\"]]");
        System.out.println("Actual: " + result3);
        System.out.println("Result: " + (checkResult3(result3) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 4: All same strings ===");
        String[] strs4 = {"a", "a", "a", "a"};
        List<List<String>> result4 = solution.groupAnagrams(strs4);
        System.out.println("Input: strs = [\"a\", \"a\", \"a\", \"a\"]");
        System.out.println("Expected: [[\"a\", \"a\", \"a\", \"a\"]]");
        System.out.println("Actual: " + result4);
        System.out.println("Result: " + (checkResult4(result4) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 5: Different lengths ===");
        String[] strs5 = {"", "", "b", "c"};
        List<List<String>> result5 = solution.groupAnagrams(strs5);
        System.out.println("Input: strs = [\"\", \"\", \"b\", \"c\"]");
        System.out.println("Expected: [[\"\"], [\"\"], [\"b\"], [\"c\"]]");
        System.out.println("Actual: " + result5);
        System.out.println("Result: " + (checkResult5(result5) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== Test Case 6: No anagrams ===");
        String[] strs6 = {"a", "b", "c", "d"};
        List<List<String>> result6 = solution.groupAnagrams(strs6);
        System.out.println("Input: strs = [\"a\", \"b\", \"c\", \"d\"]");
        System.out.println("Expected: [[\"a\"], [\"b\"], [\"c\"], [\"d\"]]");
        System.out.println("Actual: " + result6);
        System.out.println("Result: " + (checkResult6(result6) ? "PASS" : "FAIL"));
        System.out.println();

        System.out.println("=== All tests completed ===");
    }

    private static boolean checkResult1(List<List<String>> result) {
        if (result.size() != 3) return false;
        Set<Set<String>> expected = new HashSet<>();
        expected.add(new HashSet<>(Arrays.asList("bat")));
        expected.add(new HashSet<>(Arrays.asList("nat", "tan")));
        expected.add(new HashSet<>(Arrays.asList("ate", "eat", "tea")));
        Set<Set<String>> actual = new HashSet<>();
        for (List<String> group : result) {
            actual.add(new HashSet<>(group));
        }
        return expected.equals(actual);
    }

    private static boolean checkResult3(List<List<String>> result) {
        return result.size() == 1 && result.get(0).size() == 1 && result.get(0).get(0).equals("a");
    }

    private static boolean checkResult4(List<List<String>> result) {
        return result.size() == 1 && result.get(0).size() == 4;
    }

    private static boolean checkResult5(List<List<String>> result) {
        if (result.size() != 4) return false;
        Set<String> singleChars = new HashSet<>();
        singleChars.add("b");
        singleChars.add("c");
        int emptyCount = 0;
        for (List<String> group : result) {
            if (group.size() == 1) {
                if (group.get(0).isEmpty()) {
                    emptyCount++;
                } else {
                    singleChars.remove(group.get(0));
                }
            }
        }
        return emptyCount == 2 && singleChars.isEmpty();
    }

    private static boolean checkResult6(List<List<String>> result) {
        if (result.size() != 4) return false;
        Set<String> chars = new HashSet<>(Arrays.asList("a", "b", "c", "d"));
        for (List<String> group : result) {
            if (group.size() != 1) return false;
            chars.remove(group.get(0));
        }
        return chars.isEmpty();
    }
}
