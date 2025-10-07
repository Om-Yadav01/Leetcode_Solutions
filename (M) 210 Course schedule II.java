import java.util.*;

class Solution {
    public int[] findOrder(int V, int[][] prerequisites) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // Step 2: Calculate indegree
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int node : adj.get(i)) {
                indegree[node]++;
            }
        }

        // Step 3: Push nodes with indegree 0 into queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        // Step 4: Perform BFS (Kahn’s Algorithm)
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int t : adj.get(node)) {
                indegree[t]--;
                if (indegree[t] == 0) q.add(t);
            }
        }

        // Step 5: If topological sort includes all courses, return it. Otherwise return empty array.
        if (topo.size() != V) return new int[0];

        // Convert List<Integer> to int[]
        int[] order = new int[V];
        for (int i = 0; i < V; i++) {
            order[i] = topo.get(i);
        }
        return order;
    }
}
