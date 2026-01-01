# 常见错误总结

本文档记录 LeetCode Hot100 中的常见错误与陷阱。

## 目录

- [边界条件](#边界条件)
- [空指针异常](#空指针异常)
- [索引越界](#索引越界)
- [逻辑错误](#逻辑错误)
- [性能问题](#性能问题)

---

## 边界条件

### 1. 空数组或空字符串

**错误示例**：

```java
// 没有处理空数组的情况
int[] nums = new int[0];
int result = nums[0]; // IndexOutOfBoundsException
```

**正确做法**：

```java
if (nums == null || nums.length == 0) {
    return 默认值;
}
```

### 2. 单元素数组

**错误示例**：

```java
// 假设数组至少有两个元素
for (int i = 0; i < nums.length; i++) {
    if (nums[i] < nums[i + 1]) { // 可能越界
        // ...
    }
}
```

**正确做法**：

```java
for (int i = 0; i < nums.length - 1; i++) {
    if (nums[i] < nums[i + 1]) {
        // ...
    }
}
```

### 3. Integer 最小值取负

**错误示例**：

```java
int x = Integer.MIN_VALUE;
if (x < 0) {
    x = -x; // 仍然是 Integer.MIN_VALUE，因为溢出了
}
```

**正确做法**：

```java
// 使用 long 避免溢出
long x = Integer.MIN_VALUE;
if (x < 0) {
    x = -x;
}
```

---

## 空指针异常

### 1. 链表节点为空

**错误示例**：

```java
ListNode curr = head;
while (curr.next != null) {
    // 如果 curr 为 null，会抛出 NullPointerException
    curr = curr.next;
}
```

**正确做法**：

```java
ListNode curr = head;
while (curr != null) {
    // ...
    curr = curr.next;
}
```

### 2. Map 的 key 不存在

**错误示例**：

```java
Map<Integer, Integer> map = new HashMap<>();
int value = map.get(1); // 返回 null
int result = value + 1; // NullPointerException
```

**正确做法**：

```java
Map<Integer, Integer> map = new HashMap<>();
if (map.containsKey(1)) {
    int value = map.get(1);
    int result = value + 1;
}
```

或者：

```java
Map<Integer, Integer> map = new HashMap<>();
int result = map.getOrDefault(1, 0) + 1;
```

---

## 索引越界

### 1. 二分查找的区间控制

**错误示例**：

```java
int left = 0, right = nums.length;
while (left < right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) {
        return mid;
    } else if (nums[mid] < target) {
        left = mid; // 可能死循环
    } else {
        right = mid; // 可能死循环
    }
}
```

**正确做法**：

```java
int left = 0, right = nums.length - 1;
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

### 2. 滑动窗口的右边界

**错误示例**：

```java
int left = 0, right = 0;
while (right < nums.length) {
    window.add(nums[right]);
    right++;
    // 如果这里使用了 nums[right]，会越界
}
```

**正确做法**：

```java
int left = 0, right = 0;
while (right < nums.length) {
    window.add(nums[right]);
    right++;
    // 使用 nums[right - 1] 而不是 nums[right]
}
```

---

## 逻辑错误

### 1. Integer 缓存

**错误示例**：

```java
Integer a = 127;
Integer b = 127;
System.out.println(a == b); // true

Integer c = 128;
Integer d = 128;
System.out.println(c == d); // false，应该用 equals()
```

**正确做法**：

```java
Integer a = 128;
Integer b = 128;
System.out.println(a.equals(b)); // true
```

### 2. String 比较

**错误示例**：

```java
String s1 = "hello";
String s2 = new String("hello");
System.out.println(s1 == s2); // false
```

**正确做法**：

```java
String s1 = "hello";
String s2 = new String("hello");
System.out.println(s1.equals(s2)); // true
```

### 3. 循环中的数组长度变化

**错误示例**：

```java
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);

for (int i = 0; i < list.size(); i++) {
    if (list.get(i) == 2) {
        list.remove(i); // 删除后索引会变化，可能跳过元素
    }
}
```

**正确做法**：

```java
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);

Iterator<Integer> it = list.iterator();
while (it.hasNext()) {
    if (it.next() == 2) {
        it.remove();
    }
}
```

或者：

```java
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);

for (int i = list.size() - 1; i >= 0; i--) {
    if (list.get(i) == 2) {
        list.remove(i);
    }
}
```

---

## 性能问题

### 1. 字符串拼接

**错误示例**：

```java
String result = "";
for (int i = 0; i < 10000; i++) {
    result += "a"; // 每次都创建新对象，性能差
}
```

**正确做法**：

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 10000; i++) {
    sb.append("a");
}
String result = sb.toString();
```

### 2. 重复计算

**错误示例**：

```java
// 斐波那契数列，没有记忆化
public int fib(int n) {
    if (n <= 1) {
        return n;
    }
    return fib(n - 1) + fib(n - 2); // 重复计算
}
```

**正确做法**：

```java
// 使用记忆化
public int fib(int n) {
    int[] memo = new int[n + 1];
    return fibHelper(n, memo);
}

private int fibHelper(int n, int[] memo) {
    if (n <= 1) {
        return n;
    }
    if (memo[n] != 0) {
        return memo[n];
    }
    memo[n] = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
    return memo[n];
}
```

### 3. 大数据量的递归

**错误示例**：

```java
// 递归深度过大，可能导致栈溢出
public void dfs(TreeNode node) {
    if (node == null) {
        return;
    }
    dfs(node.left);
    dfs(node.right);
}
```

**正确做法**：

```java
// 对于非常深的树，考虑使用迭代
public void dfs(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        // 处理节点
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
    }
}
```

---

*本文档持续更新中...*
