class Solution {
    public int findMinDifference(List<String> list) {

        int []  minutes=new int[list.size()];

        for(int i=0;i<list.size();i++){
            String time=list.get(i);
            int h=Integer.parseInt(time.substring(0,2));
            int m=Integer.parseInt(time.substring(3));
            minutes[i]=h*60+m;
        }

        Arrays.sort(minutes);

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<minutes.length-1;i++){
            ans = Math.min(ans, minutes[i + 1] - minutes[i]);
        }

        int lastCycle=24*60-minutes[minutes.length-1]+minutes[0];

        ans=Math.min(ans,lastCycle);
        return ans;
        
    }
}