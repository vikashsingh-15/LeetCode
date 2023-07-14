class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int ans=1;
        for(int i=0;i<arr.length;i++){
            int before=map.getOrDefault(arr[i]-difference,0);
            map.put(arr[i],before+1);
            ans=Math.max(ans,map.get(arr[i]));
        }     
        return ans;
    }
}