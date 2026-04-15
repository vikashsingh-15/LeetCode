class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDist = Integer.MAX_VALUE;

        for (int i = startIndex; i < startIndex + n; i++) {
            int position = i % n;

            if (words[position].equals(target)) {
                int forward = Math.abs(position - startIndex);
                int circular = n - forward;
                int dist = Math.min(forward, circular);

                minDist = Math.min(minDist, dist);
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}