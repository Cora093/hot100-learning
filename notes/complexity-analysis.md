# 复杂度分析指南

本文档提供时间复杂度和空间复杂度的分析方法。

## 时间复杂度

### 常见复杂度等级

| 复杂度 | 名称 | 示例 |
|--------|------|------|
| O(1) | 常数时间 | 数组访问、哈希表查找 |
| O(log n) | 对数时间 | 二分查找 |
| O(n) | 线性时间 | 遍历数组 |
| O(n log n) | 线性对数时间 | 快速排序、归并排序 |
| O(n²) | 平方时间 | 双层循环、冒泡排序 |
| O(n³) | 立方时间 | 三层循环 |
| O(2ⁿ) | 指数时间 | 暴力枚举子集 |
| O(n!) | 阶乘时间 | 全排列 |

### 分析方法

#### 1. 单层循环

```java
for (int i = 0; i < n; i++) {
    // O(1) 操作
}
```
**时间复杂度**：O(n)

#### 2. 双层循环

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        // O(1) 操作
    }
}
```
**时间复杂度**：O(n²)

#### 3. 嵌套循环（内层依赖外层）

```java
for (int i = 0; i < n; i++) {
    for (int j = i; j < n; j++) {
        // O(1) 操作
    }
}
```
**时间复杂度**：O(n²)（实际上是 1+2+3+...+n = n(n+1)/2）

#### 4. 二分查找

```java
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) {
        return mid;
    } else if (nums[mid] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
```
**时间复杂度**：O(log n)

每次循环，搜索范围减半，因此循环次数为 log₂n

#### 5. 分治算法

```java
public int sort(int[] nums, int left, int right) {
    if (left >= right) {
        return 0;
    }
    int mid = left + (right - left) / 2;
    int count = sort(nums, left, mid) + sort(nums, mid + 1, right);
    // 合并操作：O(n)
    return count;
}
```
**时间复杂度**：O(n log n)

递归深度：log n
每层的工作量：O(n)
总复杂度：O(n log n)

#### 6. 动态规划（一维）

```java
int[] dp = new int[n];
dp[0] = 1;
for (int i = 1; i < n; i++) {
    dp[i] = dp[i - 1] + 1;
}
```
**时间复杂度**：O(n)

#### 7. 动态规划（二维）

```java
int[][] dp = new int[m][n];
for (int i = 1; i < m; i++) {
    for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    }
}
```
**时间复杂度**：O(m × n)

---

## 空间复杂度

### 常见空间复杂度等级

| 复杂度 | 名称 | 示例 |
|--------|------|------|
| O(1) | 常数空间 | 原地修改、只使用少量变量 |
| O(n) | 线性空间 | 额外的数组、递归栈深度 |
| O(n²) | 平方空间 | 二维 DP 数组 |
| O(log n) | 对数空间 | 递归栈深度（二分查找） |

### 分析方法

#### 1. 只使用常量空间

```java
public int findMax(int[] nums) {
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] > max) {
            max = nums[i];
        }
    }
    return max;
}
```
**空间复杂度**：O(1)

只使用了常数个变量

#### 2. 使用额外数组

```java
public int[] merge(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length + nums2.length];
    // 合并操作
    return result;
}
```
**空间复杂度**：O(n)

额外分配了长度为 n 的数组

#### 3. 递归的栈空间

```java
public int fib(int n) {
    if (n <= 1) {
        return n;
    }
    return fib(n - 1) + fib(n - 2);
}
```
**空间复杂度**：O(n)

递归的最大深度为 n，栈空间为 O(n)

#### 4. 动态规划（一维）

```java
public int climbStairs(int n) {
    if (n <= 2) {
        return n;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
```
**空间复杂度**：O(n)

使用了长度为 n+1 的数组

**优化**：

```java
public int climbStairs(int n) {
    if (n <= 2) {
        return n;
    }
    int prev2 = 1, prev1 = 2;
    for (int i = 3; i <= n; i++) {
        int curr = prev1 + prev2;
        prev2 = prev1;
        prev1 = curr;
    }
    return prev1;
}
```
**优化后的空间复杂度**：O(1)

#### 5. 动态规划（二维）

```java
public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
        dp[i][0] = 1;
    }
    for (int j = 0; j < n; j++) {
        dp[0][j] = 1;
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }
    return dp[m - 1][n - 1];
}
```
**空间复杂度**：O(m × n)

使用了 m × n 的二维数组

**优化**：

```java
public int uniquePaths(int m, int n) {
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j] + dp[j - 1];
        }
    }
    return dp[n - 1];
}
```
**优化后的空间复杂度**：O(n)

---

## 常见数据结构的复杂度

### 数组

- 访问：O(1)
- 搜索：O(n)
- 插入：O(n)
- 删除：O(n)

### 链表

- 访问：O(n)
- 搜索：O(n)
- 插入：O(1)（已知插入位置）
- 删除：O(1)（已知删除位置）

### 哈希表

- 平均访问：O(1)
- 平均搜索：O(1)
- 平均插入：O(1)
- 平均删除：O(1)

### 栈/队列

- 插入：O(1)
- 删除：O(1)
- 访问栈顶/队首：O(1)

### 优先队列（堆）

- 插入：O(log n)
- 删除堆顶：O(log n)
- 访问堆顶：O(1)

---

## 复杂度分析技巧

1. **关注最高阶**：忽略常数项和低阶项
2. **循环嵌套**：乘法关系
3. **循环并列**：加法关系，取最大
4. **递归**：使用递归树或主定理
5. **空间复杂度**：关注额外使用的空间，不包括输入

---

*本文档持续更新中...*
