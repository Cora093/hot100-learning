# LeetCode Hot 100 - Java 系统化学习

一个面向 **Java 后端工程师** 的 LeetCode Hot 100 系统学习项目

## 项目定位

- **学习对象**：LeetCode 热题 100（Top 100 Liked）
- **学习语言**：Java
- **学习周期**：12 周（3 个月）
- **学习目标**：理解题型 → 掌握解题模板 → 能独立举一反三

## 学习方法

这不是单纯的刷题，而是一个**可复盘、可迭代、可被 AI 持续推进**的学习工程。

### 核心原则

1. **以题型为核心**：识别模式，而不是死记答案
2. **建立思维模板**：对同类问题形成可迁移的解题路径
3. **注重代码质量**：可读性强、边界清晰、复杂度合理

### 学习路径

| 阶段 | 模块 | 周期 | 核心目标 |
|------|------|------|----------|
| Phase 1 | 数组 / 字符串 / 哈希 / 双指针 | Week 1-2 | 基础数据结构与线性扫描 |
| Phase 2 | 链表 / 栈 / 队列 / 单调结构 | Week 3-4 | 指针操作与线性结构 |
| Phase 3 | 二叉树 / BST / DFS / BFS | Week 5-6 | 树形结构与递归思维 |
| Phase 4 | 二分查找 / 贪心 | Week 7-8 | 剪枝与局部最优 |
| Phase 5 | 回溯 / 图 | Week 9-10 | 穷举与状态空间搜索 |
| Phase 6 | 动态规划（核心） | Week 11-12 | 最优子结构与状态转移 |

## 项目结构

```
leetcode-hot100-java
│
├── CLAUDE.md                # AI 总控提示词
├── PROJECT_STRUCTURE.md     # 项目结构说明
├── README.md                # 本文件
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
```

## 单周学习流程

每一周的学习按以下步骤进行：

1. **阅读 `README.md`**：了解本周的学习目标和题型
2. **查看 `checklist.md`**：确认本周需要完成的题目
3. **逐题学习 `problems/*.md`**：
   - 先自己思考解题思路
   - 阅读题型归类与思路分析
   - 理解 Java 实现与复杂度
   - 记录易错点与模板
4. **完成 `summary.md`**：总结本周掌握的题型与模式

## 复盘机制

- `review/wrong-questions.md`：记录每次没写对的题
- `review/second-pass.md`：二刷时只看思路，不看代码
- `review/summary.md`：项目结束后整理整体收获

## 终态目标

在项目结束时，你应当能够：

1. 熟练识别 Hot100 中的**题型分类**
2. 对常见算法问题形成**解题模板与思维路径**
3. 使用 Java 写出可读性强、边界清晰、复杂度合理的解法
4. 对中等难度题目具备 **30–60 分钟内完成的能力**

## 如何开始

1. 阅读 `CLAUDE.md` 了解项目行为规范
2. 阅读 `PROJECT_STRUCTURE.md` 了解项目结构
3. 进入 `weeks/week01-array-string/` 开始第一周学习

---

**Happy Coding! 🚀**
