# PROJECT_STRUCTURE.md

## 项目名称

leetcode-hot100-java

一个面向 **Java 后端工程师** 的
LeetCode Hot100 系统学习项目

---

## 根目录结构

```text
leetcode-hot100-java
│
├── CLAUDE.md                # AI 总控提示词（项目行为规范）
├── PROJECT_STRUCTURE.md     # 项目结构说明（本文件）
├── README.md                # 项目说明与学习方法
├── pom.xml                 # Maven 构建配置
│
├── notes/                   # 理论
│   ├── algorithm-patterns.md
│   └── my-notes.md
│
├── weeks/                   # 按周推进（12 周）
│   ├── week01-array-string/
│   ├── week02-sliding-window-hash/
│   ├── week03-linked-list/
│   ├── week04-stack-queue/
│   ├── week05-binary-tree/
│   ├── week06-bst-recursion/
│   ├── week07-binary-search/
│   ├── week08-greedy/
│   ├── week09-backtracking/
│   ├── week10-graph-bfs-dfs/
│   ├── week11-dp-basic/
│   └── week12-dp-advanced/

```

---

## 单周目录结构规范（示例）

以 `week01-array-string` 为例：

```text
week01-array-string
│
├── README.md          # 本周学习目标 & 题型说明
├── checklist.md       # 本周题目清单（Hot100）
│
├── problems/
│   ├── two-sum.md
│   ├── TwoSum.java
│   ├── max-subarray.md
│   ├── MaxSubArray.java
│   ├── longest-substring.md
│   └── LongestSubstring.java
│
└── summary.md         # 本周复盘总结
```

---

## 单题文件规范（problems/*.md）

每一道题 **必须** 包含以下结构：

````markdown
# 题目名称（LeetCode xxx）

## 1. 题目归类
- 数据结构：
- 算法思想：
- 题型标签：

## 2. 思路分析
- 暴力思路
- 优化思路
- 关键观察点

## 3. 解法实现（Java）
// Java 代码


## 4. 复杂度分析

* 时间复杂度：
* 空间复杂度：

## 5. 易错点

* 边界条件
* 常见错误

## 6. 模板沉淀

* 是否可复用
* 适用场景

````

---

## 单题 Java 文件规范（problems/*.java）

每一道题 **必须** 对应一个 Java 文件，包含：

```java
public class TwoSum {
    /**
     * 题目描述（简短）
     * LeetCode 题号: xxx
     *
     * TODO: Implement algorithm
     */
    public ReturnType methodName(参数列表) {
        // TODO: Your implementation here

        return defaultValue;
    }

    /**
     * 测试用例
     * 使用 main 方法进行本地测试
     */
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // 测试用例 1
        // 输入: ...
        // 期望输出: ...
        // 实际输出: ...

        // 测试用例 2
        // ...

        System.out.println("测试完成!");
    }
}
```

**规范要求**：
1. **类名规范**：
   - 使用帕斯卡命名法（PascalCase）
   - 根据题目名称命名，例如：TwoSum、MaxSubArray、LongestSubstring
   - 文件名必须与类名完全一致（包括大小写）
2. **算法实现**：
   - **禁止直接生成完整实现**
   - 只提供方法签名和 TODO 注释
   - 由学习者自己完成实现
3. main 方法中包含完整的测试用例
4. 测试用例应覆盖：
   - 常规情况
   - 边界情况（空、单元素、极值）
   - 特殊情况
5. 测试输出格式统一：
   - 使用 PASS/FAIL 标记测试结果
   - 清晰展示输入、期望输出、实际输出

## 构建与测试规范

### Maven 构建

项目使用 Maven 进行构建和管理。

**根目录 pom.xml 配置**：
- 指定源代码目录为 `weeks/week01-array-string/problems`
- Java 版本：17
- 使用 exec-maven-plugin 运行 main 方法

**构建命令**：
```bash
# 编译
mvn clean compile

# 运行特定类
mvn exec:java -Dexec.mainClass="ClassName"
```

### 禁止使用 javac

**禁止直接使用 javac 编译**，必须通过 Maven 进行编译和运行。

---

## 复盘与进阶规则

- `summary.md`：总结本周掌握的 **题型与模式**

---

## 设计原则

1. **以题型为核心，而不是题目本身**
2. **所有内容可被 AI 反复引用**
3. **为面试而设计，但不为应试而刷**

