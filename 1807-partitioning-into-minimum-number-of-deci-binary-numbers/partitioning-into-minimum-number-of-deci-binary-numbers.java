class Solution {
    public int minPartitions(String n) {
        int Max=0;
        for(int i=0;i<n.length();i++){
            int x=n.charAt(i)-'0';
            Max=Math.max(x,Max);
        }
        return Max;
        
        
    }
}
