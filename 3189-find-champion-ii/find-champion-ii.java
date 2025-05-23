public class Solution {

    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];

        for (int[] edge : edges) {
            indegree[edge[1]]++;
        }

        int champion = -1;
        int champCount = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                champCount++;
                champion = i;
            }
        }

        return champCount > 1 ? -1 : champion;
    }
}