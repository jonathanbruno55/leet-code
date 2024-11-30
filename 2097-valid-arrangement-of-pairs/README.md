# 2097. Valid Arrangement of Pairs

## Problem Description

You are given a 0-indexed 2D integer array `pairs` where `pairs[i] = [starti, endi]`. An arrangement of pairs is valid if for every index \( i \) where \( 1 \leq i < \text{pairs.length} \), we have:

\[
\text{end}\_{i-1} = \text{start}\_i
\]

Return any valid arrangement of pairs.

**Note**: The inputs are guaranteed to generate a valid arrangement of pairs.

---

## Examples

### Example 1:

**Input**:
`pairs = [[5, 1], [4, 5], [11, 9], [9, 4]]`
**Output:**  
`[[11, 9], [9, 4], [4, 5], [5, 1]]`
**Explanation:**

1. end0=9=start1
2. end1=4=start2
3. end2=5=start3

​---

### Example 2:

**Input**:
`pairs = [[1, 3], [3, 2], [2, 1]]`
**Output:**  
`[[1, 3], [3, 2], [2, 1]]`
**Explanation:**

1. end0=9=start1
2. end1=2=start2

Other valid arrangements include:
[[2,1],[1,3],[3,2]]
[[3,2],[2,1],[1,3]]

​---

### Example 3:

**Input**:
`pairs = [[1, 2], [1, 3], [2, 1]]`
**Output:**  
`[[1, 2], [2, 1], [1, 3]]`
**Explanation:**

1. end0=2=start1
2. end1=1=start2

---

## Constraints

- `1≤pairs.length≤10^5`
- `pairs[i].length=2`
- `0≤starti,endi≤10^9`
- `starti/=endi`
- `No two pairs are exactly the same.`
- `The input guarantees that a valid arrangement of pairs exists.`

---

## Approach

This problem can be reduced to finding an Eulerian path in a directed graph:

1.  Key Observations:
    Each pair[u,v] represents a directed edge u→v.

    The task is to arrange the pairs such that the end of one pair matches the start of the next.

    This is equivalent to finding an Eulerian path, a path that visits each edge exactly once.

2.  Conditions for an Eulerian Path:
    For all nodes except two:
    in-degree=out-degree.

    For the start node:
    out-degree−in-degree=1.

    For the end node:
    in-degree−out-degree=1.

3.  Algorithm:
    Build a directed graph using the pairs.

    Use Hierholzer’s algorithm to construct the Eulerian path:
    Start from a node with more outgoing edges than incoming edges.

        Traverse the graph while removing edges, adding nodes to the path in reverse order.

    Reverse the path to get the correct order.

## How to Run

1. Save the Java solution in a file named `ValidArrangement.java`.
2. Compile the file:
   ```bash
   javac ValidArrangement.java
   ```
3. Run the program:
   ```bash
   java ValidArrangement
   ```
4. The program will output the results for the provided test cases.

---

## Complexity

Time Complexity:
O(E), where E is the number of edges (pairs). Building the graph and finding the path both take O(E).

Space Complexity:
O(V+E), where V is the number of unique nodes and E is the number of edges.
