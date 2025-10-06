import java.util.*;

class Solution {

    private boolean checkBipartite(int start, int V, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0; // start coloring with 0

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for (int it : adj.get(node)) {
                // if the adjacent node is not colored, give it opposite color
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                // if the adjacent node has the same color → not bipartite
                else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1); // initialize all vertices as uncolored

        // Graph might be disconnected → check every component
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!checkBipartite(i, V, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
