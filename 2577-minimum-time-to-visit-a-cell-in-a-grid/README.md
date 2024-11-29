# 2577. Minimum Time to Visit a Cell in a Grid

## Problem Description

You are given an `m x n` matrix `grid` consisting of non-negative integers where `grid[row][col]` represents the **minimum time required** to be able to visit the cell `(row, col)`. This means you can visit the cell `(row, col)` **only when the time you visit it is greater than or equal to `grid[row][col]`**.

You start at the top-left cell `(0, 0)` at time `0` and must move to any adjacent cell in four directions: up, down, left, and right. Each move takes 1 second.

Return the **minimum time required** to reach the bottom-right cell `(m-1, n-1)`. If it is not possible to reach the bottom-right cell, return `-1`.

---

## Examples

### Example 1:

**Input**:  
`grid = [[0, 1, 3, 2], [5, 1, 2, 5], [4, 3, 8, 6]]`
**Output:**  
`7`
**Explanation:**  
At t=0, start at cell (0, 0).
At t=1, move to cell (0, 1). Allowed because t≥grid[0][1].
At t=2, move to cell (1, 1). Allowed because t≥grid[1][1].
At t=3, move to cell (1, 2). Allowed because t≥grid[1][2].
At t=4, move back to cell (1, 1). Allowed because t≥grid[1][1].
At t=5, move to cell (1, 2) again. Allowed because t≥grid[1][2].
At t=6, move to cell (1, 3). Allowed because t≥grid[1][3].
At t=7, move to cell (2, 3). Allowed because t≥grid[2][3].
The total time taken is 7, which is the minimum possible.

---

### Example 2

**Input:**
`grid = [[0, 2, 4], [3, 2, 1], [1, 0, 4]]`
**Output:**  
`-1`
**Explanation:**
It is not possible to reach the bottom-right cell (2, 2).

---

## Constraints

- `2≤m,n≤1000`
- `4≤𝑚⋅𝑛≤10^5`
- `0≤grid[row][col]≤10^5`
- `grid[0][0]=0`

---

## Approach

We use Dijkstra's algorithm with a priority queue to find the minimum time to reach the bottom-right cell while respecting the grid constraints:

Key Observations:

Each move takes 1 second.

We can only move to a cell (row, col) at time 𝑡 if t≥grid[row][col].

If t and the grid constraint don’t align, we may need to wait an extra second to satisfy the condition.

Algorithm:

Use a priority queue to process cells in increasing order of the time to reach them.

For each cell (row, col) at time t:
Check all valid adjacent cells.
Compute the next possible time to move to the adjacent cell.
Adjust for parity (wait if necessary).

Stop when reaching (m-1, n-1) or return -1 if unreachable.

Edge Case:

If both adjacent cells (0, 1) and (1, 0) are initially blocked (
grid[0][1]> grid[0][1]>1 and > grid[1][0]>1), return -1.

## Algorithm

1.  Graph Representation:

    Treat the grid as a graph where each cell is a node.

    Moving to an adjacent cell (newRow, newCol) has a cost of 1.

2.  Priority Queue:

    Use a priority queue to always process the cell that can be reached at the earliest possible time.

3.  Parity Adjustment:

    If t<grid[newRow][newCol], wait until t=grid[newRow][newCol].

    If (t−grid[newRow][newCol])%2 =/0, wait an additional second to match the parity.

4.  Termination:

    Return the time when the bottom-right cell (m-1, n-1) is dequeued.

    Return -1 if the queue is exhausted without visiting (m-1, n-1).

## How to Run

1. Save the Java solution in a file named `MinimumTime.java`.
2. Compile the file:
   ```bash
   javac MinimumTime.java
   ```
3. Run the program:
   ```bash
   java MinimumTime
   ```
4. The program will output the results for the provided test cases.
