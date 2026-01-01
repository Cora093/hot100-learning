# 买卖股票的最佳时机（LeetCode 121）

## 1. 题目归类
- **数据结构**：数组
- **算法思想**：动态规划、贪心
- **题型标签**：数组、动态规划、单调性

## 2. 思路分析

### 暴力思路
对于每一天，尝试在它之前买入，计算利润，取最大值。

**问题**：
- 时间复杂度 O(n²)，效率低

### 优化思路
维护两个变量：
- `minPrice`：遍历过程中遇到的最小价格（买入的最佳时机）
- `maxProfit`：最大利润

**关键观察**：
- 对于每一天，如果知道它之前的最小价格，就能计算以当天卖出的最大利润
- 最大利润 = 当天价格 - 之前的最小价格
- 只需要遍历一次数组，不断更新最小价格和最大利润

**为什么有效**：
- 我们不需要知道哪一天卖，只需要知道在哪一天买最划算
- 维护最小买入价格，计算每天卖出能获得的最大利润
- 取所有可能利润中的最大值

### 边界考虑
- 数组可能为空或只有一个元素
- 价格一直下降，没有利润
- 所有价格都相同

## 3. 解法实现（Java）

```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            // 计算以当天卖出的利润
            int profit = prices[i] - minPrice;
            // 更新最大利润
            maxProfit = Math.max(maxProfit, profit);
            // 更新最小价格
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        return maxProfit;
    }
}
```

## 4. 复杂度分析

- **时间复杂度**：O(n)
  - 只需要遍历一次数组

- **空间复杂度**：O(1)
  - 只使用了两个变量

## 5. 易错点

1. **数组为空或只有一个元素**
   - 无法买卖，利润为 0
   - 需要提前判断

2. **更新顺序**
   - 先计算利润，再更新最小价格
   - 确保不会在同一天买卖

3. **最大利润可能为负**
   - 题目要求返回 0，不返回负数

4. **初始值设置**
   - minPrice 应该初始化为第一个元素，而不是 0 或 Integer.MAX_VALUE

## 6. 模板沉淀

### 模板：维护最大/最小值

**适用场景**：
- 需要找到数组中的极值
- 需要同时维护最大值和最小值
- 需要根据之前的状态计算当前状态

**模板代码**：

```java
public int maxProfit(int[] prices) {
    int minPrice = prices[0];
    int maxProfit = 0;
    
    for (int price : prices) {
        maxProfit = Math.max(maxProfit, price - minPrice);
        minPrice = Math.min(minPrice, price);
    }
    
    return maxProfit;
}
```

**适用题目**：
- 买卖股票的最佳时机
- 需要同时维护最大值和最小值的问题

**扩展**：
- 如果可以多次买卖，问题会变得不同（LeetCode 122）
- 如果需要考虑交易手续费或冷却期，需要更复杂的动态规划
