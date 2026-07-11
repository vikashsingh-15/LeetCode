import java.util.*;

class Solution {

    int vertices;
    int edges;

    public int countCompleteComponents(int V, int[][] grid) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : grid) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                vertices = 0;
                edges = 0;

                dfsIsComplete(i, visited, adj);

                edges /= 2;

                if (edges == vertices * (vertices - 1) / 2) {
                    count++;
                }
            }
        }

        return count;
    }

    public void dfsIsComplete(int node, boolean[] visited,
                              ArrayList<ArrayList<Integer>> adj) {

        visited[node] = true;
        vertices++;

        edges += adj.get(node).size();

        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfsIsComplete(neighbour, visited, adj);
            }
        }
    }
}