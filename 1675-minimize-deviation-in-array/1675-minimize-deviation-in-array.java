class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int mv=Integer.MAX_VALUE;
        for(int x:nums){
            if((x&1)==1)
                x<<=1;
            pq.add(x);
            mv =Math.min( mv ,x);
        }
        int md =Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int curr=pq.poll();
            md = Math.min(md ,curr-mv);
            if((curr&1)==1)
                break;
            curr>>=1;
            mv=Math.min(mv,curr);
            pq.add(curr);
        }
        return md;
    }
}