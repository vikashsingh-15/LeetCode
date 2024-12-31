//TLE
// class Solution {
//     public int mincostTickets(int[] days, int[] costs) {
//         return minCost(0, days, costs);
//     }
    
//     private int minCost(int i, int[] days, int[] costs) {
//         if (i >= days.length) {
//             return 0;
//         }
        
//         int cost1 = costs[0] + minCost(i + 1, days, costs);
        
//         int j = i;
//         while (j < days.length && days[j] < days[i] + 7) {
//             j++;
//         }
//         int cost7 = costs[1] + minCost(j, days, costs);
        
//         j = i;
//         while (j < days.length && days[j] < days[i] + 30) {
//             j++;
//         }
//         int cost30 = costs[2] + minCost(j, days, costs);
    
//         return Math.min(cost1, Math.min(cost7, cost30));
//     }
// }



// class Solution {
//     public int mincostTickets(int[] days, int[] costs) {
//        return minCost(0, days, costs, new int [days.length]);
//     }
    
//     private int minCost(int i, int[] days, int[] costs,int dp[]) {
//         if (i >= days.length) {
//             return 0;
//         }

//         if(dp[i]!=0){
//             return dp[i];
//         }        

//         int cost1 = costs[0] + minCost(i + 1, days, costs,dp);
        
//         int j = i;
//         while (j < days.length && days[j] < days[i] + 7) {
//             j++;
//         }
//         int cost7 = costs[1] + minCost(j, days, costs,dp);
        
//         j = i;
//         while (j < days.length && days[j] < days[i] + 30) {
//             j++;
//         }
//         int cost30 = costs[2] + minCost(j, days, costs,dp);
        
//         dp[i]= Math.min(cost1, Math.min(cost7, cost30));
//         return dp[i];
//     }
// }


class Solution {
    public int mincostTickets(int[] days, int[] costs) {
         int[] dp = new int[days.length+1];
        int monthStart = 1;
        int weekStart = 1;  
        for(int i=0;i<days.length;i++){
            int dayPass = costs[0] + dp[i];
            while(days[i]-days[weekStart-1]+1>7)
                weekStart++;
            int weekPass = costs[1] + dp[weekStart-1];
            while(days[i]-days[monthStart-1]+1>30)
                monthStart++;
            int monthPass = costs[2] + dp[monthStart-1];
            dp[i+1] = Math.min(dayPass,Math.min(weekPass,monthPass));
        }
        return dp[days.length];
    }
}

