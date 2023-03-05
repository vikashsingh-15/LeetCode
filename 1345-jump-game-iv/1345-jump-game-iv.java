class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0; // already at the last index
        }
        Map<Integer, List<Integer>> indices = new HashMap<>(); // map values to indices
        for (int i = 0; i < n; i++) {
            indices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        boolean[] visited = new boolean[n]; // keep track of visited indices
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n - 1) {
                    return steps; // reached the last index
                }
                List<Integer> nextIndices = indices.get(arr[curr]);
                nextIndices.add(curr - 1);
                nextIndices.add(curr + 1);
                for (int next : nextIndices) {
                    if (next >= 0 && next < n && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
                nextIndices.clear(); // clear the list for next iteration
            }
            steps++; // increment step count after processing all indices at current level
        }
        return -1; // not able to reach the last index
    }
}
