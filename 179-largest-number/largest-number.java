class Solution {
    public String largestNumber(int[] nums) {
        String[] arr=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=Integer.toString(nums[i]);
        }

        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));
        if(arr[0].equals("0")){
            return "0";
        }
        StringBuilder largest = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            largest.append(arr[i]);
        }
        return largest.toString();
    }
}