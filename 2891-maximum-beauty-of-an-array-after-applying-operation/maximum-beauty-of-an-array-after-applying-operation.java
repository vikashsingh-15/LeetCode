class Solution {
    public int maximumBeauty(int[] arr, int k) {
        Arrays.sort(arr);
        int right=0;
        int max=0;

        for(int left=0;left<arr.length;left++){
            while(right<arr.length && arr[right]<=arr[left]+2*k){
                right++;
            }
            max=Math.max(max,right-left);
        }
        return max;
    }
}