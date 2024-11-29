import java.util.*;

@SuppressWarnings("unused")
public class FindChampionII {
    public int findChampion(int n, int[][] edges) {
        // Step 1: Initialize in-degree array
        int[] inDegree = new int[n];

        // Step 2: Calculate in-degrees from edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            inDegree[to]++;
        }

        // Step 3: Identify the team with in-degree 0
        int champion = -1; // Default: no champion
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (champion == -1) {
                    champion = i; // First candidate for champion
                } else {
                    return -1; // Multiple teams with in-degree 0
                }
            }
        }

        // Step 4: Check if we found a unique champion
        return champion;
    }

    public static void main(String[] args) {
        FindChampionII fc = new FindChampionII();

        // Example 1
        int n1 = 3;
        int[][] edges1 = { { 0, 1 }, { 1, 2 } };
        System.out.println(fc.findChampion(n1, edges1)); // Output: 0

        // Example 2
        int n2 = 4;
        int[][] edges2 = { { 0, 2 }, { 1, 3 }, { 1, 2 } };
        System.out.println(fc.findChampion(n2, edges2)); // Output: -1
    }
}
