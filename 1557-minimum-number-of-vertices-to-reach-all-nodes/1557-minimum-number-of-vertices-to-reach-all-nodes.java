class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
          int[] indegree = new int[n];
        // Iterate through all the edges and update the indegree of each node.
        for (List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }
        // Create an answer list.
        List<Integer> ans = new ArrayList<>();
        // Iterate through all the vertices and add the ones with an indegree of 0 to the answer list.
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                ans.add(i);
            }
        }
        // Return the answer list.
        return ans;
    }
}