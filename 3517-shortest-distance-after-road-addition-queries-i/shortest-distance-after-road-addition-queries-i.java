//wrong approach fails a lot
// class Solution {
//     public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int[] dp = new int[n];
//         dp[n - 1] = 0; 
//         for (int i = n - 2; i >= 0; i--) {
//             dp[i] = 1 + dp[i + 1];
//         }

//         int[] result = new int[queries.length];

//         for (int q = 0; q < queries.length; q++) {
//             int u = queries[q][0], v = queries[q][1];
//             dp[u] = Math.min(dp[u], 1 + dp[v]); 

//             for (int i = u ; i >= 0; i--) {
//                 dp[i] = Math.min(dp[i], 1 + dp[i + 1]);
//                 if(map.containsKey(i)){
//                     dp[i]=Math.min(dp[map.get(i)]+1,dp[i]);
//                 }
//             }

//             result[q] = dp[0];
//             if(map.containsKey(u)){
//                 if(v>map.get(u)){
//                     map.put(u,v);
//                 }
//             }else{
//                 map.put(u,v);
//             }  
//         }
//         return result;
//     }
// }

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] dp = new int[n];

        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = 1 + dp[i + 1];
        }

        int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int u = queries[q][0], v = queries[q][1];
            dp[u] = Math.min(dp[u], 1 + dp[v]);

            map.putIfAbsent(u, new ArrayList<>());
            map.get(u).add(v);

            for (int i = u; i >= 0; i--) {
                dp[i] = Math.min(dp[i], 1 + dp[i + 1]);
                if (map.containsKey(i)) {
                    for (int j = 0; j < map.get(i).size(); j++) {
                        int end = map.get(i).get(j);
                        dp[i] = Math.min(dp[i], 1 + dp[end]);
                    }
                }
            }
            result[q] = dp[0];
        }

        return result;
    }
}
