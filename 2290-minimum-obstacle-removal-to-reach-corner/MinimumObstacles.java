import java.util.*;

public class MinimumObstacles {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Directions for moving up, down, left, right
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // Deque for 0-1 BFS
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[] { 0, 0, 0 }); // {row, col, obstacles removed}

        // Visited array
        int[][] visited = new int[m][n];
        for (int[] row : visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        visited[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0], y = current[1], cost = current[2];

            // If we reach the bottom-right corner, return the cost
            if (x == m - 1 && y == n - 1) {
                return cost;
            }

            // Explore neighbors
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check bounds
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newCost = cost + grid[newX][newY];
                    // If this path offers a cheaper way, update and add to deque
                    if (newCost < visited[newX][newY]) {
                        visited[newX][newY] = newCost;
                        if (grid[newX][newY] == 0) {
                            deque.addFirst(new int[] { newX, newY, newCost }); // Priority for free cells
                        } else {
                            deque.addLast(new int[] { newX, newY, newCost }); // Add cost for obstacles
                        }
                    }
                }
            }
        }

        return -1; // Should never reach here as there's always a path
    }

    public static void main(String[] args) {
        MinimumObstacles solver = new MinimumObstacles();

        // Example 1
        int[][] grid1 = { { 0, 1, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
        System.out.println(solver.minimumObstacles(grid1)); // Output: 2

        // Example 2
        int[][] grid2 = { { 0, 1, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 1, 0 } };
        System.out.println(solver.minimumObstacles(grid2)); // Output: 0
    }
}
