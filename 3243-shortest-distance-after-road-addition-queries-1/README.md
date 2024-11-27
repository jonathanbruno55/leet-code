# 3243. Shortest Distance After Road Addition Queries I

## Problem Description

You are given an integer `n` and a 2D integer array `queries`.

There are `n` cities numbered from `0` to `n - 1`. Initially, there is a unidirectional road from city `i` to city `i + 1` for all `0 <= i < n - 1`.

`queries[i] = [ui, vi]` represents the addition of a new unidirectional road from city `ui` to city `vi`. After each query, you need to find the length of the shortest path from city `0` to city `n - 1`.

Return an array `answer` where for each `i` in the range `[0, queries.length - 1]`, `answer[i]` is the length of the shortest path from city `0` to city `n - 1` after processing the first `i + 1` queries.

---

## Examples

### Example 1:

**Input**:  
`n = 5`
`queries = [[2, 4], [0, 2], [0, 4]]`
**Output:**  
`[3, 2, 1]`
**Explanation:**

1. After the addition of the road from 2 to 4, the length of the shortest path from 0 to 4 is 3.
2. After the addition of the road from 0 to 2, the length of the shortest path from 0 to 4 is 2.
3. After the addition of the road from 0 to 4, the length of the shortest path from 0 to 4 is 1.

---

### Example 2:

**Input**:  
`n = 4`
`queries = [[0, 3], [0, 2]]`
**Output:**  
`[1, 1]`
**Explanation:**

1. After the addition of the road from 0 to 3, the length of the shortest path from 0 to 3 is 1.
2. After the addition of the road from 0 to 2, the length of the shortest path remains 1.

---

## Constraints

- `3 <= n <= 500`
- `1 <= queries.length <= 500`
- `queries[i].length == 2`
- `0 <= queries[i][0] < queries[i][1] < n`
- `1 < queries[i][1] - queries[i][0]`
- `There are no repeated roads among the queries.`

---

## Approach

1. Graph Representation:
   Represent the cities and roads as a graph using an adjacency list.

   Start with the initial graph where there is a road from city i to i + 1 for all i.

2. Processing Queries:
   For each query, dynamically add a new road [ui, vi] to the graph.

   Recalculate the shortest path from city 0 to city n - 1.

3. Shortest Path Calculation:
   Use a Breadth-First Search (BFS) to compute the shortest path after each road addition.

   BFS is efficient for this graph structure because all edge weights are uniform.

4. Result Collection:
   After processing each query, store the shortest path length in the result array.

## Algorithm

1. Initialize the graph with roads from city i to i + 1.
2. For each query:
   Add the new road to the graph.
   Perform a BFS to find the shortest path from city 0 to city n - 1.
   Store the shortest path length in the result array.
3. Return the result array after all queries are processed.

## How to Run

1. Save the Java solution in a file named `FindChampionII.java`.
2. Compile the file:
   ```bash
   javac ShortestDistanceAfterRoadAddition.java
   ```
3. Run the program:
   ```bash
   java ShortestDistanceAfterRoadAddition
   ```
4. The program will output the results for the provided test cases.
