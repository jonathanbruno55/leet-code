# Sliding Puzzle

## Problem Description

On a 2 x 3 board, there are five tiles labeled from `1` to `5`, and an empty square represented by `0`. A move consists of choosing `0` and a 4-directionally adjacent number and swapping them.

The state of the board is solved if and only if the board is `[[1,2,3],[4,5,0]]`.

Given the puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return `-1`.

## Examples

### Example 1

**Input:**  
`board = [[1, 2, 3], [4, 0, 5]]`  
**Output:**  
`1`  
**Explanation:**  
Swap the `0` and the `5` in one move.

---

### Example 2

**Input:**  
`board = [[1, 2, 3], [5, 4, 0]]`  
**Output:**  
`-1`  
**Explanation:**  
No number of moves will make the board solved.

---

### Example 3

**Input:**  
`board = [[4, 1, 2], [5, 0, 3]]`  
**Output:**  
`5`  
**Explanation:**  
`5` is the smallest number of moves that solves the board. An example path:

1. After move 0: `[[4, 1, 2], [5, 0, 3]]`
2. After move 1: `[[4, 1, 2], [0, 5, 3]]`
3. After move 2: `[[0, 1, 2], [4, 5, 3]]`
4. After move 3: `[[1, 0, 2], [4, 5, 3]]`
5. After move 4: `[[1, 2, 0], [4, 5, 3]]`
6. After move 5: `[[1, 2, 3], [4, 5, 0]]`

---

## Constraints

- `board.length == 2`
- `board[i].length == 3`
- `0 <= board[i][j] <= 5`
- Each value `board[i][j]` is unique.

---

## Approach

The problem is solved using **Breadth-First Search (BFS)**:

1. Treat each board configuration as a node in a graph.
2. Perform BFS starting from the initial board configuration.
3. Track visited configurations to avoid revisiting.
4. Count the number of moves (levels in BFS) to reach the target configuration.

---

## How to Run

1. Save the Java code in a file named `SlidingPuzzle.java`.
2. Compile the file:
   ```bash
   javac SlidingPuzzle.java
   ```
