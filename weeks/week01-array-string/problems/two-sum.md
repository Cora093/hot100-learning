# 两数之和（LeetCode 1）

## 1. 题目归类
- **数据结构**：数组、哈希表
- **算法思想**：一次遍历、空间换时间
- **题型标签**：数组、哈希表、查找问题

## 2. 思路分析

### 暴力思路
遍历数组中的每个元素，对于每个元素，再遍历后面的所有元素，看是否有另一个数与当前数的和等于 target。

**问题**：
- 时间复杂度 O(n²)，效率低
- 对于大数组会超时

### 优化思路
使用哈希表来存储已经遍历过的元素及其索引。

**关键观察**：
- 对于当前元素 nums[i]，我们需要找 target - nums[i]
- 如果 target - nums[i] 之前出现过，我们就找到了答案
- 如果没出现过，就把当前元素和索引存入哈希表，供后续查找使用

**为什么有效**：
- 哈希表的查找是 O(1)
- 只需要遍历一次数组
- 空间换时间，用额外的空间降低时间复杂度

### 边界考虑
- 数组中至少有两个元素（题目保证）
- 一定有且只有一解（题目保证）
- 不能使用同一个元素两次

## 3. 解法实现（Java）

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1};
    }
}
```

## 4. 复杂度分析

- **时间复杂度**：O(n)
  - 只需要遍历一次数组
  - 哈希表的查找和插入都是 O(1)

- **空间复杂度**：O(n)
  - 最坏情况下，哈希表需要存储所有元素
  - 如果答案在最后两个元素，需要存储 n-2 个元素

## 5. 易错点

1. **使用同一个元素两次**
   - 错误做法：先遍历完把所有元素放入哈希表，然后再查找
   - 正确做法：边遍历边查找，确保不会使用当前元素本身

2. **返回的顺序**
   - 题目要求返回的索引顺序不限
   - 但需要确保返回的是两个不同的索引

3. **空数组处理**
   - 题目保证数组长度至少为 2，所以不需要处理
   - 但在实际编码中，可以加上边界检查

4. **HashMap 的使用**
   - 注意使用 `containsKey()` 检查键是否存在
   - 注意 `put(key, value)` 的顺序

## 6. 模板沉淀

### 模板：使用哈希表进行配对查找

**适用场景**：
- 在数组中找两个数，使其满足某种关系（和、差、积等）
- 需要快速查找某个数是否存在

**模板代码**：

```java
public int[] findPair(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        
        map.put(nums[i], i);
    }
    
    return null;
}
```

**适用题目**：
- 两数之和
- 类似的三数之和（需要变通）

**扩展**：
- 如果数组已排序，可以使用双指针
- 如果找三个数，可以考虑排序 + 双指针或哈希表 + 双重循环
