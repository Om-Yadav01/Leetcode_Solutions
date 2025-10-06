class Solution {
    private void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis) {
        vis[node] = 1;
        for (Integer it : adjList.get(node)) {
            if (vis[it] == 0) {
                dfs(it, adjList, vis);
            }
        }
    }

    public int findCircleNum(int[][] adj) {
        int V = adj.length;

        // Step 1: Convert adjacency matrix to adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }int[] vis = new int[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                count++;
                dfs(i, adjList, vis);
            }
        }

        return count;}}
