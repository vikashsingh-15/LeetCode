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



class Solution {
    public int mincostTickets(int[] days, int[] costs) {
       return minCost(0, days, costs, new int [days.length]);
    }
    
    private int minCost(int i, int[] days, int[] costs,int dp[]) {
        if (i >= days.length) {
            return 0;
        }

        if(dp[i]!=0){
            return dp[i];
        }        

        int cost1 = costs[0] + minCost(i + 1, days, costs,dp);
        
        int j = i;
        while (j < days.length && days[j] < days[i] + 7) {
            j++;
        }
        int cost7 = costs[1] + minCost(j, days, costs,dp);
        
        j = i;
        while (j < days.length && days[j] < days[i] + 30) {
            j++;
        }
        int cost30 = costs[2] + minCost(j, days, costs,dp);
        
        dp[i]= Math.min(cost1, Math.min(cost7, cost30));
        return dp[i];
    }
}

