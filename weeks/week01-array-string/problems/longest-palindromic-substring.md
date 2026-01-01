# 最长回文子串（LeetCode 5）

## 1. 题目归类
- **数据结构**：字符串
- **算法思想**：动态规划、中心扩展
- **题型标签**：字符串、动态规划、回文

## 2. 思路分析

### 暴力思路
枚举所有子串，判断是否是回文，取最长的。

**问题**：
- 时间复杂度 O(n³)，其中 n 是字符串长度
- 效率太低

### 优化思路 1：动态规划
使用动态规划记录子串是否是回文。

**关键观察**：
- 回文串的子串也是回文串
- 如果 s[l+1..r-1] 是回文串，且 s[l] == s[r]，则 s[l..r] 也是回文串
- dp[i][j] 表示 s[i..j] 是否是回文串

**转移方程**：
- 单字符：dp[i][i] = true
- 两个字符：dp[i][i+1] = (s[i] == s[i+1])
- 多个字符：dp[i][j] = dp[i+1][j-1] && (s[i] == s[j])

### 优化思路 2：中心扩展
从中心向两边扩展。

**关键观察**：
- 回文串是对称的，可以中心扩展
- 中心可以是一个字符（奇数长度），也可以是两个字符（偶数长度）
- 对于每个位置，尝试奇数扩展和偶数扩展

**为什么有效**：
- 避免重复计算
- 时间复杂度 O(n²)
- 空间复杂度 O(1)

### 边界考虑
- 空字符串
- 单个字符
- 所有字符相同
- 没有长度大于 1 的回文串

## 3. 解法实现（Java）

### 方法 1：动态规划

```java
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        int n = s.length();
        int maxLen = 1;
        int start = 0;
        boolean[][] dp = new boolean[n][n];
        
        // 单字符都是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // 枚举子串长度
        for (int len = 2; len <= n; len++) {
            // 枚举左边界
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (len > maxLen) {
                            maxLen = len;
                            start = i;
                        }
                    }
                }
            }
        }
        
        return s.substring(start, start + maxLen);
    }
}
```

### 方法 2：中心扩展

```java
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        int maxLen = 0;
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // 奇数长度回文串
            int len1 = expandAroundCenter(s, i, i);
            // 偶数长度回文串
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        
        return s.substring(start, start + maxLen);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
```

## 4. 复杂度分析

### 动态规划
- **时间复杂度**：O(n²)
  - 枚举子串长度 O(n)
  - 对于每个长度枚举左边界 O(n)

- **空间复杂度**：O(n²)
  - dp 数组

### 中心扩展
- **时间复杂度**：O(n²)
  - 遍历每个位置 O(n)
  - 每个位置最多扩展 O(n)

- **空间复杂度**：O(1)
  - 只使用常数空间

## 5. 易错点

1. **边界条件**
   - 空字符串和单字符需要单独处理
   - 两个字符需要单独判断

2. **动态规划的初始化**
   - 单字符初始化为 true
   - 两个字符需要特殊处理

3. **中心扩展的索引**
   - 计算起始位置时要注意
   - left - (len - 1) / 2

4. **substring 的使用**
   - substring(start, end) 是 [start, end)
   - 需要正确计算结束位置

## 6. 模板沉淀

### 模板：中心扩展

**适用场景**：
- 需要找到最长的满足对称性质的子串
- 回文串问题
- 可以中心扩展的问题

**模板代码**：

```java
public int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    return right - left - 1;
}

public String findLongest(String s) {
    int maxLen = 0;
    int start = 0;
    
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);     // 奇数
        int len2 = expandAroundCenter(s, i, i + 1); // 偶数
        
        int len = Math.max(len1, len2);
        if (len > maxLen) {
            maxLen = len;
            start = i - (len - 1) / 2;
        }
    }
    
    return s.substring(start, start + maxLen);
}
```

**适用题目**：
- 最长回文子串
- 回文子串的个数
- 回文串相关问题

**扩展**：
- Manacher 算法可以在 O(n) 时间内解决
- 可以找到所有回文子串
- 可以计算回文子串的个数
