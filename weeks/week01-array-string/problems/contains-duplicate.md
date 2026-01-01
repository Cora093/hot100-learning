# 存在重复元素（LeetCode 217）

## 1. 题目归类
- **数据结构**：数组、哈希表
- **算法思想**：哈希去重
- **题型标签**：数组、哈希表、查找问题

## 2. 思路分析

### 暴力思路
使用双重循环，对于每个元素，检查后面的元素是否有相等的。

**问题**：
- 时间复杂度 O(n²)，效率低

### 优化思路
使用哈希表来判断元素是否已经出现过。

**关键观察**：
- 使用 HashSet 存储已经遍历过的元素
- 遍历数组，如果当前元素已经在 Set 中，说明有重复
- 如果不在 Set 中，则加入 Set
- 如果遍历完都没有重复，返回 false

**为什么有效**：
- HashSet 的查找和插入都是 O(1)
- 只需要遍历一次数组
- 利用 HashSet 的唯一性特性

### 边界考虑
- 数组可能为空
- 数组可能只有一个元素
- 所有元素都相同
- 元素可能为负数

## 3. 解法实现（Java）

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        
        return false;
    }
}
```

## 4. 复杂度分析

- **时间复杂度**：O(n)
  - 只需要遍历一次数组
  - HashSet 的查找和插入都是 O(1)

- **空间复杂度**：O(n)
  - 最坏情况下，HashSet 需要存储所有元素

## 5. 易错点

1. **数组为空**
   - 空数组没有重复元素，返回 false
   - 空数组没有问题，因为循环不会执行

2. **HashSet 的使用**
   - 注意使用 `contains()` 检查元素是否存在
   - 注意 `add()` 方法的使用

3. **返回值**
   - 发现重复就立即返回 true
   - 遍历完都没有重复才返回 false

## 6. 模板沉淀

### 模板：使用 HashSet 判断重复

**适用场景**：
- 判断数组中是否有重复元素
- 需要快速查找某个元素是否存在
- 需要去重

**模板代码**：

```java
public boolean hasDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    
    for (int num : nums) {
        if (set.contains(num)) {
            return true;
        }
        set.add(num);
    }
    
    return false;
}
```

**适用题目**：
- 存在重复元素
- 数组去重相关的问题

**扩展**：
- 如果只需要知道有多少重复，可以使用 HashMap 计数
- 如果需要找出所有重复的元素，可以存储在 List 中
