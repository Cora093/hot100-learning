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
│
├── notes/                   # 理论 & 总结笔记
│   ├── algorithm-patterns.md
│   ├── common-mistakes.md
│   └── complexity-analysis.md
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
│
└── review/                  # 复盘与二刷
    ├── wrong-questions.md
    ├── second-pass.md
    └── summary.md
````

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
│   ├── max-subarray.md
│   └── longest-substring.md
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

## 复盘与进阶规则

- `summary.md`：总结本周掌握的 **题型与模式**
- `wrong-questions.md`：记录没一次写对的题
- `second-pass.md`：二刷时只看思路，不看代码

---

## 设计原则

1. **以题型为核心，而不是题目本身**
2. **所有内容可被 AI 反复引用**
3. **为面试而设计，但不为应试而刷**

