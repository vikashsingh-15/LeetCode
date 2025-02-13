class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            pq.add((long)nums[i]);
        }
        int count = 0;

        while (pq.size() > 1 && pq.peek()<k) {
            long first = pq.poll();
            long sec = pq.poll();
            long x = 0;
            System.out.println("count="+count);
            System.out.print(" First ="+ first);
            System.out.print(" sec ="+ sec);


            if (first < k || sec < k) {
                x = (Math.min(first, sec) * 2) + Math.max(first, sec);
                pq.add(x);
                count++;
            }

            System.out.print(" x ="+ x);
        }

        return count;
    }
}