import java.util.*;

class Tuple {
    int distance;
    int row;
    int col;

    public Tuple(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        // Min-heap based on distance
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, (int) 1e9);

        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Tuple t = pq.poll();
            int diff = t.distance;
            int row = t.row;
            int col = t.col;

            if (row == n - 1 && col == m - 1) return diff;

            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    int newEffort = Math.max(
                            Math.abs(heights[row][col] - heights[newRow][newCol]),
                            diff
                    );

                    if (newEffort < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newEffort;
                        pq.add(new Tuple(newEffort, newRow, newCol));
                    }
                }
            }
        }

        return 0;
    }
}
