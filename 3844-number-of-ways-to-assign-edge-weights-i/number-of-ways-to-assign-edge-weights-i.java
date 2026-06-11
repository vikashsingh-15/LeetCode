class Solution {
    private static final long MOD = 1_000_000_007L;

    public int assignEdgeWeights(int[][] edges) {
         int n = edges.length + 1;

         List<Integer>[] tree = new ArrayList[n + 1];
         for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }


         for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            tree[u].add(v);
            tree[v].add(u);
        }

        boolean[] visited = new boolean[n + 1];
        int maxDepth = maxDepth(1, tree, visited);

        return (int) modPow(2, maxDepth - 1);


    }

    static int maxDepth(int node, List<Integer>[] tree, boolean[] visited) {
        visited[node] = true;

        int depth = 0;

        for (int child : tree[node]) {
            if (!visited[child]) {
                depth = Math.max(depth,
                        1 + maxDepth(child, tree, visited));
            }
        }

        return depth;
    }

    static long modPow(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) { // if b is odd
                result = (result * a) % MOD;
            }

            a = (a * a)% MOD; // square the base
            b >>= 1; // divide exponent by 2
        }

        return result;
    }

}