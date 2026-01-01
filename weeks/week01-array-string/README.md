# Week 1：数组与字符串

## 本周目标

1. 熟练掌握数组的遍历和操作
2. 理解字符串的处理技巧
3. 掌握基础的双指针思想
4. 学会原地修改数组的方法

## 题型说明

### 数组基础操作

数组是最基础的数据结构，掌握数组的操作是解决其他问题的基础。

**核心技巧**：
- 双指针（同向、相向）
- 原地修改
- 滑动窗口（简单版）

### 字符串处理

字符串本质上是字符数组，处理方式与数组类似，但需要注意一些特殊操作。

**核心技巧**：
- 字符串遍历
- 子串判断
- 字符统计

## 本周涵盖的 Hot 100 题目

详见 `checklist.md`

## 学习建议

1. **先思考，再看答案**：每道题先自己思考 10-15 分钟
2. **理解思路**：重点关注解题思路，而不仅仅是代码
3. **总结模式**：做完题后，思考这类问题的通用解法
4. **注意边界**：特别注意空数组、单元素等边界情况
5. **运行测试**：每道题完成后，使用 Maven 运行测试进行验证

## 如何使用 Java 文件

### 项目构建

项目使用 Maven 进行构建和管理。首次使用前，确保已安装 Maven。

**Maven 配置**：
- 源代码目录：`weeks/week01-array-string/problems`
- Java 版本：17
- 构建输出：`target/classes`

### 单独运行测试

使用 Maven 编译和运行：

```bash
# 编译项目
mvn clean compile

# 运行特定类的测试
mvn exec:java -Dexec.mainClass="TwoSum"
mvn exec:java -Dexec.mainClass="MaxSubArray"
mvn exec:java -Dexec.mainClass="LongestSubstring"
```

**注意**：
- 禁止使用 `javac` 直接编译
- 必须通过 Maven 进行编译和运行
- Java 文件只提供方法签名，需要自己实现算法

### 批量运行所有测试

使用测试脚本批量运行所有测试：

**Linux/Mac**：
```bash
./run-tests.sh
```

**Windows**：
```batch
run-tests.bat
```

### 测试结果

每个测试用例会显示：
- Input：输入数据
- Expected：期望输出
- Actual：实际输出
- Result：PASS（通过）或 FAIL（失败）

**已生成的 Java 文件**：
- `TwoSum.java` - 两数之和（LeetCode 1）
- `MaxSubArray.java` - 最大子数组和（LeetCode 53）
- `LongestSubstring.java` - 无重复字符的最长子串（LeetCode 3）

**注意**：Java 文件中只包含方法签名和测试用例，**算法实现需要自己完成**！

## 预计学习时间

- 每道题：30-60 分钟
- 总时间：3-5 小时（约 5-8 道题）

---

**完成日期**：______
