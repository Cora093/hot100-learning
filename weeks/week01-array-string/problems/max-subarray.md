# 最大子数组和（LeetCode 53）

## 1. 题目归类
- **数据结构**：数组
- **算法思想**：动态规划、贪心
- **题型标签**：数组、动态规划、子数组问题

## 2. 思路分析

### 暴力思路
枚举所有可能的子数组，计算每个子数组的和，取最大值。

**问题**：
- 有 O(n²) 个子数组
- 计算每个子数组的和是 O(n)
- 总时间复杂度 O(n³)，效率太低

**优化**：使用前缀和，可以在 O(1) 时间内计算子数组和，总复杂度 O(n²)，但仍然不够优。

### 优化思路

#### 思路 1：动态规划

**关键观察**：
- 对于以 nums[i] 结尾的子数组，其最大和要么是：
  - 继续前面的子数组：dp[i-1] + nums[i]
  - 从当前元素重新开始：nums[i]
- 取两者的较大值

**状态定义**：
- dp[i]：以 nums[i] 结尾的子数组的最大和

**状态转移方程**：
- dp[i] = max(dp[i-1] + nums[i], nums[i])

**答案**：
- max(dp[i]) for all i

#### 思路 2：贪心（Kadane 算法）

**关键观察**：
- 遍历数组，维护当前子数组的和
- 如果当前和为负数，就没有必要继续累加（因为负数只会让后面的和变小）
- 此时应该从下一个元素重新开始

**算法步骤**：
1. 初始化 currentSum = 0, maxSum = 负无穷
2. 遍历数组：
   - currentSum = max(currentSum + nums[i], nums[i])
   - maxSum = max(maxSum, currentSum)
3. 返回 maxSum

### 边界考虑
- 数组元素全为负数：答案是最大的负数
- 数组长度为 1：答案就是该元素
- 数组中有正有负：正确处理正负交替的情况

## 3. 解法实现（Java）

### 解法 1：动态规划

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = dp[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        
        return maxSum;
    }
}
```

### 解法 2：贪心（空间优化）

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int num : nums) {
            currentSum = Math.max(currentSum + num, num);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
```

## 4. 复杂度分析

- **时间复杂度**：O(n)
  - 只需要遍历一次数组

- **空间复杂度**：
  - 动态规划：O(n)
  - 贪心：O(1)

## 5. 易错点

1. **初始值的设定**
   - maxSum 的初始值应该是 Integer.MIN_VALUE，而不是 0
   - 因为数组可能全为负数

2. **currentSum 的更新**
   - 先更新 currentSum，再更新 maxSum
   - 不要弄反顺序

3. **全负数的情况**
   - 此时答案应该是最大的负数
   - 贪心算法能够正确处理

4. **理解状态转移**
   - dp[i] 表示"以 nums[i] 结尾"的子数组
   - 不是"前 i 个元素"的子数组

## 6. 模板沉淀

### 模板：Kadane 算法（最大子数组和）

**适用场景**：
- 求连续子数组的最大和
- 可以变形为求最小和、最大乘积等

**模板代码**：

```java
public int maxSubArray(int[] nums) {
    int currentSum = 0;
    int maxSum = Integer.MIN_VALUE;
    
    for (int num : nums) {
        currentSum = Math.max(currentSum + num, num);
        maxSum = Math.max(maxSum, currentSum);
    }
    
    return maxSum;
}
```

**扩展变形**：
- **最小子数组和**：把 max 改成 min
- **最大乘积子数组**：需要维护最大值和最小值（因为有负数）
- **指定长度的子数组最大和**：使用滑动窗口

**动态规划模板**：

```java
public int maxSubArray(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = nums[0];
    int maxSum = dp[0];
    
    for (int i = 1; i < n; i++) {
        dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        maxSum = Math.max(maxSum, dp[i]);
    }
    
    return maxSum;
}
```

**适用题目**：
- 最大子数组和
- 最大乘积子数组（需要变通）
- 环形子数组的最大和（需要变通）
