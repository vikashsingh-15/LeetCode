class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visit = new boolean[n];
        boolean[] inStack = new boolean[n];
        List<Integer> nonCyclic = new ArrayList<>(); 

       
        for (int i = 0; i < n; i++) {
            dfs(i, graph, visit, inStack, nonCyclic);
        }
         Collections.sort(nonCyclic);
        return  nonCyclic;
    }

    public boolean dfs(int node, int[][] graph, boolean[] visit, boolean[] inStack, List<Integer> nonCyclic) {
       
        if (inStack[node]) {
            return true;
        }       
        if (visit[node]) {
            return false;
        }
        visit[node] = true;
        inStack[node] = true;
        for (int neighbour : graph[node]) {
            if (dfs(neighbour, graph, visit, inStack, nonCyclic)) {
                return true; // Cycle detected
            }
        }
        inStack[node] = false;
        nonCyclic.add(node);
        return false;
    }
}
