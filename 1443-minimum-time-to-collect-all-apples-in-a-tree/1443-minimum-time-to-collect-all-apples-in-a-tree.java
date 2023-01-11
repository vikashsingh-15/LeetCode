 class Solution {
        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }

            return Math.max(0, calculateTravel(graph, -1, 0, hasApple) - 1); // -1 because the return value is +1
        }

        private int calculateTravel(Map<Integer, List<Integer>> graph, int parent, int node, List<Boolean> hasApple) {
            int travelCost = 0;

            for (int child : graph.get(node)) {
                if (child == parent) continue;

                int childTravelCost = calculateTravel(graph, node, child, hasApple);
                if (childTravelCost != 0) {
                    travelCost += childTravelCost + 1; // +1 because I go down
                }
            }
            return (travelCost == 0 && !hasApple.get(node)) ? 0 : travelCost + 1;


        }
    }