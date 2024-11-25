import java.util.*;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        // Target board state
        String target = "123450";

        // Convert the 2D board to a single string for easy comparison
        StringBuilder start = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }

        // BFS setup
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start.toString());
        visited.add(start.toString());

        // Directions for moving the empty tile (0)
        int[][] directions = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // Check if the current state is the target state
                if (current.equals(target)) {
                    return steps;
                }

                // Find the index of '0' (empty tile)
                int zeroIndex = current.indexOf('0');

                // Try all possible moves
                for (int dir : directions[zeroIndex]) {
                    String next = swap(current, zeroIndex, dir);
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            steps++;
        }

        // If no solution is found
        return -1;
    }

    // Helper function to swap characters in a string
    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    public static void main(String[] args) {
        SlidingPuzzle sp = new SlidingPuzzle();

        int[][] board1 = { { 1, 2, 3 }, { 4, 0, 5 } };
        System.out.println(sp.slidingPuzzle(board1)); // Output: 1

        int[][] board2 = { { 1, 2, 3 }, { 5, 4, 0 } };
        System.out.println(sp.slidingPuzzle(board2)); // Output: -1

        int[][] board3 = { { 4, 1, 2 }, { 5, 0, 3 } };
        System.out.println(sp.slidingPuzzle(board3)); // Output: 5
    }
}
