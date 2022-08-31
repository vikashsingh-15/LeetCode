class Solution {
    public int titleToNumber(String str) {
        if(str.length()==1){
            return (int)(str.charAt(0)-'A'+1);
        }
        int length=str.length();
        int sum=0;
        // int ans=0;
        for(int i=0;i<str.length();i++){
            int valueOfChar=(int)(str.charAt(i)-'A'+1);
            int val=valueOfChar*((int)Math.pow(26,length-i-1));
            sum+=val;
        }
        return sum;
        
    }
}