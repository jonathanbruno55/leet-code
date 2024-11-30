import java.util.*;

public class ValidArrangement {
    public int[][] validArrangement(int[][] pairs) {
        // Step 1: Build the graph
        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            int u = pair[0], v = pair[1];
            graph.putIfAbsent(u, new ArrayDeque<>());
            graph.putIfAbsent(v, new ArrayDeque<>());
            graph.get(u).add(v);

            outDegree.put(u, outDegree.getOrDefault(u, 0) + 1);
            inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
        }

        // Step 2: Find the start node
        int start = pairs[0][0]; // Default start node
        for (int node : graph.keySet()) {
            if (outDegree.getOrDefault(node, 0) > inDegree.getOrDefault(node, 0)) {
                start = node;
                break;
            }
        }

        // Step 3: Find Eulerian path using Hierholzer's algorithm
        List<int[]> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (graph.get(node).isEmpty()) {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.add(new int[] { stack.peek(), node });
                }
            } else {
                stack.push(graph.get(node).poll());
            }
        }

        // Reverse the result because we collect it in reverse order
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        ValidArrangement solver = new ValidArrangement();

        // Example 1
        int[][] pairs1 = { { 5, 1 }, { 4, 5 }, { 11, 9 }, { 9, 4 } };
        System.out.println(Arrays.deepToString(solver.validArrangement(pairs1)));
        // Output: [[11,9],[9,4],[4,5],[5,1]]

        // Example 2
        int[][] pairs2 = { { 1, 3 }, { 3, 2 }, { 2, 1 } };
        System.out.println(Arrays.deepToString(solver.validArrangement(pairs2)));
        // Output: [[1,3],[3,2],[2,1]]

        // Example 3
        int[][] pairs3 = { { 1, 2 }, { 1, 3 }, { 2, 1 } };
        System.out.println(Arrays.deepToString(solver.validArrangement(pairs3)));
        // Output: [[1,2],[2,1],[1,3]]
    }
}
