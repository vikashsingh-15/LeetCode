class Solution {
    public int[] minOperations(String str) {
        int[] ans = new int[str.length()];

        for(int i=0;i<str.length();i++){
            int count=0;
            for(int j=0;j<str.length();j++){
                if(i==j){

                }if(str.charAt(j)=='1'){
                    count+=Math.abs(j-i);
                }

            }
            ans[i]=count;
        }
        return ans;
    }
}