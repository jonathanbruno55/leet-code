# 2924. Find Champion II

## Problem Description

There are `n` teams numbered from `0` to `n - 1` in a tournament; each team is also a node in a Directed Acyclic Graph (DAG).

You are given the integer `n` and a 0-indexed 2D integer array `edges` of length `m` representing the DAG, where `edges[i] = [ui, vi]` indicates that there is a directed edge from team `ui` to team `vi` in the graph.

- A directed edge from `a` to `b` in the graph means that team `a` is stronger than team `b`**, and **team `b` is weaker than team `a`.
- Team `a` will be the champion of the tournament if there is no team `b` that is stronger than team `a`.

Return the team that will be the champion of the tournament if there is a unique champion, otherwise, return `-1`.

### Notes:

- A cycle is a series of nodes `a1, a2, ..., an, an+1` such that:
  - Node `a1` is the same as node `an+1`.
  - Nodes `a1, a2, ..., an` are distinct.
  - There is a directed edge from the node `ai` to node `ai+1` for every `i` in the range `[1, n]`.
- A **DAG** is a directed graph that does not have any cycles.

---

## Examples

### Example 1

**Input:**
`n = 3`
`edges = [[0, 1], [1, 2]]`
**Output:**  
`0`
**Explanation:**  
Team 1 is weaker than team 0.
Team 2 is weaker than team 1.
Therefore, the champion is team 0.

---

### Example 2

**Input:**
`n = 4`
`edges = [[0, 2], [1, 3], [1, 2]]`
**Output:**  
`-1`
**Explanation:**
Team 2 is weaker than teams 0 and 1.
Team 3 is weaker than team 1.
Teams 0 and 1 are not weaker than any other teams.
Since there is no unique champion, the output is -1.

---

## Constraints

- `1 <= n <= 100`
- `m == edges.length`
- `0 <= m <= n \* (n - 1) / 2`
- `edges[i].length == 2`
- `0 <= edges[i][j] <= n - 1`
- `edges[i][0] != edges[i][1]`

The input is generated such that:
If team a is stronger than team b, then team b is not stronger than team a.
If team a is stronger than team b and team b is stronger than team c, then team a is stronger than team c.

---

## Approach

The solution involves the following steps:

In-Degree Calculation:

Compute the in-degree of each team (node). The in-degree of a node is the count of edges directed into it.
A node with an in-degree of 0 has no stronger teams (no incoming edges).
Identify Champion:

If there is exactly one node with an in-degree of 0, that node is the champion.
If there are multiple such nodes or none, return -1.

## Algorithm

1. Initialize an array inDegree of size n to track the in-degree of each team.
2. Traverse the list of edges:
   For each edge [u, v], increment the in-degree of v.
3. Identify the node with an in-degree of 0:
   If there is exactly one node with an in-degree of 0, return it as the champion.
   Otherwise, return -1.

## How to Run

1. Save the Java solution in a file named `FindChampionII.java`.
2. Compile the file:
   ```bash
   javac FindChampionII.java
   ```
3. Run the program:
   ```bash
   java FindChampionII
   ```
4. The program will output the results for the provided test cases.
