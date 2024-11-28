# 2290. Minimum Obstacle Removal to Reach Corner

## Problem Description

You are given a 0-indexed 2D integer array `grid` of size `m x n`. Each cell in the grid has one of two values:

- `0` represents an empty cell.
- `1` represents an obstacle that may be removed.

You can move **up**, **down**, **left**, or **right** between empty cells (`0`).

Return the **minimum number of obstacles to remove** to move from the **upper-left corner** `(0, 0)` to the **lower-right corner** `(m - 1, n - 1)`.

---

## Examples

### Example 1:

**Input**:  
`grid = [[0, 1, 1], [1, 1, 0], [1, 1, 0]]`
**Output:**  
`2`
**Explanation:**

1. We can remove the obstacles at (0, 1) and (0, 2) to create a path from (0, 0) to (2, 2).
2. It can be shown that we need to remove at least 2 obstacles, so the output is 2.
3. Note: There may be other ways to remove 2 obstacles to create a path.

---

### Example 2:

**Input**:  
`grid = [[0, 1, 0, 0, 0], [0, 1, 0, 1, 0], [0, 0, 0, 1, 0]]`
**Output:**  
`0`
**Explanation:**

1. We can move from (0, 0) to (2, 4) without removing any obstacles, so the output is 0.

---

## Constraints

- `1 ≤ m, n ≤ 10^5`
- `2 ≤ 𝑚 ⋅ 𝑛 ≤ 10^5`
- `2 ≤ m ⋅ n ≤ 10`
- `grid[i][j] is either 0 or 1.`
- `grid[0][0] == 0 and grid[m - 1][n - 1] == 0.`

---

## Approach

To solve this problem, we can use 0-1 Breadth-First Search (BFS):

1.  Key Observations:
    Cells with 0 (empty cells) can be moved to without cost.

    Cells with 1 (obstacles) require a cost of 1 to remove.

    We need to minimize the total cost (number of obstacles removed).

2.  Algorithm:
    Use a deque (Deque) to implement 0-1 BFS:

        Add cells with 0 cost to the front of the deque.

        Add cells with 1 cost to the back of the deque.

    Track the minimum cost to reach each cell using a visited array.

3.  Why 0-1 BFS?:
    Efficiently prioritizes free paths (0 cost) over obstacles (1 cost).

    Avoids the overhead of a full Dijkstra's algorithm.

4.  Termination:
    When the bottom-right corner is reached, return the cost.

## Algorithm

1.  Graph Representation:
    Treat each cell as a node in a graph.

    Movement between cells depends on whether the target cell is empty (0) or an obstacle (1).

2.  Deque-Based BFS:
    Initialize a deque and add the starting cell (0, 0) with cost 0.

    For each cell, explore its neighbors (up, down, left, right):

        If the neighbor is an empty cell, add it to the front of the deque.

        If the neighbor is an obstacle, add it to the back of the deque.

    Track the minimum cost to reach each cell using a visited array.

3.  Result Collection:\
    Return the cost when the bottom-right corner (m - 1, n - 1) is reached.

## How to Run

1. Save the Java solution in a file named `MinimumObstacles.java`.
2. Compile the file:
   ```bash
   javac MinimumObstacles.java
   ```
3. Run the program:
   ```bash
   java MinimumObstacles
   ```
4. The program will output the results for the provided test cases.
