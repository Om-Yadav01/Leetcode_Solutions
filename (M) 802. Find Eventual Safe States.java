import java.util.*;

class Solution {

    private boolean dfsCheck(int node, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] check) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        // traverse adjacent nodes
        for (int it : adj.get(node)) {
            // if node is not visited
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis, check) == true) {
                    return true;
                }
            }
            // if node is visited and is on the same path -> cycle
            else if (pathVis[it] == 1) {
                return true;
            }
        }

        // no cycle detected → safe node
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        // convert input array to adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int it : graph[i]) {
                adj.get(i).add(it);
            }
        }

        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];

        // run DFS for all nodes
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }

        // collect all safe nodes
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i] == 1) safeNodes.add(i);
        }
        return safeNodes;
    }
}
