class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int apoint=0;
        int bpoint=n-1;
        int maxArea=-1;
        while(apoint<bpoint){
            maxArea=Math.max(maxArea,(Math.min(height[apoint],height[bpoint])*(bpoint-apoint)));
            if(height[apoint]<=height[bpoint]){
                apoint++;
            }else{
                bpoint--;
            }
        }

        return maxArea;
        
    }
}