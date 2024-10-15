class Solution {
    public long minimumSteps(String s) {
        int white=0;
        long black=0;
        long ans=0;
        while(white<s.length()){
            if(s.charAt(white)=='0'){
                ans+=(white-black);
                black++;
            }
            white++;
        }

    return ans;
    }
}