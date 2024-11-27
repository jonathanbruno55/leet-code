
import java.util.*;

public class ShortestDistanceAfterRoadAddition {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Step 1: Initialize the adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(new int[] { i + 1, 1 }); // Default road from i to i+1
        }

        // Result array
        int[] result = new int[queries.length];

        // Step 2: Process each query
        for (int k = 0; k < queries.length; k++) {
            int u = queries[k][0], v = queries[k][1];
            graph.get(u).add(new int[] { v, 1 }); // Add new road

            // Step 3: Compute shortest path from 0 to n-1
            result[k] = bfsShortestDistanceAfterQueries(graph, n);
        }

        return result;
    }

    // Helper function to calculate shortest path using BFS
    private int bfsShortestDistanceAfterQueries(List<List<int[]>> graph, int n) {
        Queue<int[]> queue = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        queue.add(new int[] { 0, 0 }); // Start from node 0 with distance 0
        dist[0] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0], currentDist = current[1];

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if (currentDist + weight < dist[nextNode]) {
                    dist[nextNode] = currentDist + weight;
                    queue.add(new int[] { nextNode, dist[nextNode] });
                }
            }
        }

        return dist[n - 1]; // Return distance to node n-1
    }

    public static void main(String[] args) {
        ShortestDistanceAfterRoadAddition solver = new ShortestDistanceAfterRoadAddition();

        // Example 1
        int n1 = 5;
        int[][] queries1 = { { 2, 4 }, { 0, 2 }, { 0, 4 } };
        System.out.println(Arrays.toString(solver.shortestDistanceAfterQueries(n1, queries1))); // Output: [3, 2, 1]

        // Example 2
        int n2 = 4;
        int[][] queries2 = { { 0, 3 }, { 0, 2 } };
        System.out.println(Arrays.toString(solver.shortestDistanceAfterQueries(n2, queries2))); // Output: [1, 1]
    }
}
