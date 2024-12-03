# 迭代与二叉树遍历算法

迭代是一种算法设计技术，与递归相对应。在迭代中，问题的解决方案通过反复执行一个基本操作来逐步构建，而不是通过递归调用函数。

## 迭代的基本思想

1. **基本操作的重复执行**：迭代通过重复执行一个基本操作来逐步解决问题。这个基本操作可以是对数据结构的遍历、状态更新等。
2. **无需递归调用**：不同于递归，迭代不需要函数调用栈来管理调用状态，而是使用数据结构（如栈或队列）来保存状态并进行处理。

## 二叉树遍历的迭代实现

在二叉树遍历中，常见的迭代方法包括前序、中序和后序遍历。这些方法利用栈来模拟递归过程，以达到遍历树的目的。

### 前序遍历迭代算法

- 使用栈保存待处理节点。
- 将当前节点压入栈中，然后访问当前节点并处理。
- 若存在左子节点，则将左子节点作为新的当前节点继续处理；否则，弹出栈顶节点，转向右子节点。

### 中序遍历迭代算法

- 初始时将根节点入栈。
- 迭代过程中，不断将左子节点入栈直至为空，然后弹出栈顶节点访问并处理。
- 若存在右子节点，则将右子节点入栈并作为新的当前节点继续。

### 后序遍历迭代算法

- 使用两个栈或栈的变形，先按照根右左的顺序遍历树。
- 然后将结果翻转就可以得到左右根的后序遍历。