// class Solution {
//     public int[] restoreArray(int[][] adjacentPairs) {
//         Map<Integer, List<Integer>> graph = new HashMap<>();

//         for (int[] pair : adjacentPairs) {
//             graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
//             graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
//         }

//         List<Integer> result = new ArrayList<>();

//         for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
//             if (entry.getValue().size() == 1) {
//                 result.add(entry.getKey());
//                 result.add(entry.getValue().get(0));
//                 break;
//             }
//         }

//         while (result.size() < adjacentPairs.length + 1) {
//             int last = result.get(result.size() - 1);
//             int prev = result.get(result.size() - 2);
//             List<Integer> candidates = graph.get(last);
//             int nextElement = candidates.get(0) != prev ? candidates.get(0) : candidates.get(1);
//             result.add(nextElement);
//         }

//         return result.stream().mapToInt(Integer::intValue).toArray();
//     }
// }

class Solution {
    private List<Integer> result = new ArrayList<>();

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            int u = adjacentPairs[i][0];
            int v = adjacentPairs[i][1];

            if (map.containsKey(u)) {
                map.get(u).add(v);
            } else {
                map.put(u, new ArrayList<>());
                map.get(u).add(v);
            }

            if (map.containsKey(v)) {
                map.get(v).add(u);
            } else {
                map.put(v, new ArrayList<>());
                map.get(v).add(u);
            }
        }

        int startPoint = -1;

        for (Integer key : map.keySet()) {
            List<Integer> value = map.get(key);
            if (value.size() == 1) {
                startPoint = key;
                break;
            }
        }
        solve(startPoint, Integer.MIN_VALUE, map);
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    private void solve(int u, int prev, Map<Integer, List<Integer>> map) {
        result.add(u);
        //prev is needed to keep track of visited
        for (int v : map.get(u)) {
            if (v != prev) {
                solve(v, u, map);
            }
        }
    }
}
