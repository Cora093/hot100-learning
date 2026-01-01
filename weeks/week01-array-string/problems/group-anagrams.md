# 字母异位词分组（LeetCode 49）

## 1. 题目归类
- **数据结构**：数组、哈希表、字符串
- **算法思想**：哈希映射、排序
- **题型标签**：字符串、哈希表、分组问题

## 2. 思路分析

### 暴力思路
对于每个字符串，与其他所有字符串比较，看是否是字母异位词。

**问题**：
- 时间复杂度 O(n² × m log m)，其中 m 是字符串长度
- 效率太低

### 优化思路
使用哈希表进行分组。

**关键观察**：
- 字母异位词排序后是相同的
- 可以将排序后的字符串作为 key，原字符串列表作为 value
- 使用 HashMap 进行分组

**另一种优化**：
- 不需要排序，可以使用字符计数作为 key
- 对于小写字母，可以使用长度为 26 的数组
- 将数组转换为字符串作为 key

**为什么有效**：
- 排序后相同的字符串一定是字母异位词
- HashMap 的查找和插入都是 O(1)
- 将 O(n²) 的问题转化为 O(n)

### 边界考虑
- 数组为空
- 字符串为空
- 所有字符串都相同
- 字符串长度不同（不是字母异位词）

## 3. 解法实现（Java）

### 方法 1：排序

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // 将字符串排序
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // 使用哈希表分组
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
```

### 方法 2：字符计数

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // 使用字符计数作为 key
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            // 将数组转换为字符串
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            
            // 使用哈希表分组
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
```

## 4. 复杂度分析

### 方法 1：排序
- **时间复杂度**：O(n × k log k)
  - n 是字符串数量
  - k 是字符串的最大长度
  - 对每个字符串排序需要 O(k log k)

- **空间复杂度**：O(n × k)
  - 哈希表存储所有字符串

### 方法 2：字符计数
- **时间复杂度**：O(n × k)
  - 对每个字符串遍历一次字符
  - 构建字符串 key 需要常数时间（26）

- **空间复杂度**：O(n × k)
  - 哈希表存储所有字符串

## 5. 易错点

1. **空字符串的处理**
   - 空字符串排序后还是空字符串
   - 多个空字符串应该分在同一组

2. **字符串长度不同**
   - 长度不同的字符串不是字母异位词
   - 排序后会自动区分

3. **HashMap 的使用**
   - 注意检查 key 是否存在
   - 注意初始化 List

4. **返回结果**
   - 返回的是 map.values()
   - 顺序不重要，只要分组正确

## 6. 模板沉淀

### 模板：使用 HashMap 进行分组

**适用场景**：
- 需要将元素按照某种规则分组
- 需要找到具有相同特征的元素
- 需要去重或合并

**模板代码**：

```java
public List<List<T>> groupBy(T[] array) {
    Map<K, List<T>> map = new HashMap<>();
    
    for (T item : array) {
        K key = computeKey(item);
        
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(item);
    }
    
    return new ArrayList<>(map.values());
}
```

**适用题目**：
- 字母异位词分组
- 相似字符串分组
- 根据特征分组的问题

**扩展**：
- 可以使用 TreeMap 保持顺序
- 可以使用 computeIfAbsent 简化代码
- 可以根据具体需求调整 key 的计算方式
