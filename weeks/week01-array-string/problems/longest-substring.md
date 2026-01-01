# 无重复字符的最长子串（LeetCode 3）

## 1. 题目归类
- **数据结构**：字符串、哈希表
- **算法思想**：滑动窗口
- **题型标签**：字符串、滑动窗口、双指针

## 2. 思路分析

### 暴力思路
枚举所有可能的子串，检查每个子串是否有重复字符，取最长的。

**问题**：
- 有 O(n²) 个子串
- 检查每个子串需要 O(n) 时间
- 总时间复杂度 O(n³)，效率太低

### 优化思路

使用滑动窗口算法。

**关键观察**：
- 我们要找的是最长的无重复字符的子串
- 可以用一个窗口表示当前的子串 [left, right)
- 如果窗口内的字符都不重复，就扩大窗口
- 如果窗口内出现重复字符，就缩小窗口

**算法步骤**：
1. 使用哈希表（或数组）记录每个字符最后出现的位置
2. 初始化 left = 0, maxLen = 0
3. 遍历字符串，right 从 0 到 n-1：
   - 如果当前字符在窗口内出现过，就移动 left 到重复字符的下一个位置
   - 更新当前字符的位置为 right
   - 更新 maxLen = max(maxLen, right - left + 1)

### 边界考虑
- 字符串为空：返回 0
- 字符串全相同：返回 1
- 字符串全不重复：返回字符串长度

## 3. 解法实现（Java）

### 解法 1：使用 HashMap

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
```

### 解法 2：使用数组（更高效）

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastPos = new int[128];
        Arrays.fill(lastPos, -1);
        
        int left = 0;
        int maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            if (lastPos[c] >= left) {
                left = lastPos[c] + 1;
            }
            
            lastPos[c] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
```

## 4. 复杂度分析

- **时间复杂度**：O(n)
  - 每个字符最多被访问两次（一次作为 right，一次作为 left）

- **空间复杂度**：
  - HashMap：O(min(m, n))，其中 m 是字符集大小
  - 数组：O(1)，因为字符集大小固定（ASCII 128 或 256）

## 5. 易错点

1. **left 的移动**
   - 不是简单地移动到 map.get(c) + 1
   - 只有当重复字符在窗口内时才需要移动
   - 判断条件：map.get(c) >= left

2. **maxLen 的更新时机**
   - 在更新 left 和 map 之后
   - 不要在更新之前计算长度

3. **窗口的表示**
   - [left, right] 是闭区间
   - 窗口长度 = right - left + 1

4. **字符集的选择**
   - HashMap 可以处理任意字符
   - 数组更高效，但需要知道字符集大小
   - 对于 ASCII，使用长度 128 的数组

## 6. 模板沉淀

### 模板：滑动窗口（无重复元素的最长子串）

**适用场景**：
- 找最长/最短的子串/子数组
- 子串/子数组满足某种条件
- 可以用窗口的收缩和扩张来维护条件

**模板代码**：

```java
public int slidingWindow(String s) {
    int left = 0, right = 0;
    int maxLen = 0;
    Map<Character, Integer> window = new HashMap<>();
    
    while (right < s.length()) {
        // 扩大窗口，加入 s.charAt(right)
        char c = s.charAt(right);
        window.put(c, window.getOrDefault(c, 0) + 1);
        right++;
        
        // 判断窗口是否需要收缩
        while (不满足条件) {
            // 缩小窗口，移除 s.charAt(left)
            char d = s.charAt(left);
            window.put(d, window.get(d) - 1);
            if (window.get(d) == 0) {
                window.remove(d);
            }
            left++;
        }
        
        // 更新答案
        maxLen = Math.max(maxLen, right - left);
    }
    
    return maxLen;
}
```

**本题的简化版**：

```java
public int lengthOfLongestSubstring(String s) {
    int[] lastPos = new int[128];
    Arrays.fill(lastPos, -1);
    
    int left = 0, maxLen = 0;
    
    for (int right = 0; right < s.length(); right++) {
        if (lastPos[s.charAt(right)] >= left) {
            left = lastPos[s.charAt(right)] + 1;
        }
        lastPos[s.charAt(right)] = right;
        maxLen = Math.max(maxLen, right - left + 1);
    }
    
    return maxLen;
}
```

**适用题目**：
- 无重复字符的最长子串
- 最小覆盖子串（需要变通）
- 长度最小的子数组（需要变通）

**关键要点**：
- 明确窗口的含义：[left, right)
- 扩大窗口：right++
- 缩小窗口：left++
- 更新答案：在满足条件时
