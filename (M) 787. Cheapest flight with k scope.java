import java.util.*;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple {
    int first;   // stops
    int second;  // node
    int third;   // cost

    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        // Step 2: Queue for BFS -> (stops, node, totalCost)
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        // Step 3: Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        // Step 4: BFS
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            int stops = t.first;
            int node = t.second;
            int cost = t.third;

            if (stops > k) continue;

            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.second;

                if (cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple(stops + 1, adjNode, cost + edW));
                }
            }
        }

        return dist[dst] == (int) 1e9 ? -1 : dist[dst];
    }
}
