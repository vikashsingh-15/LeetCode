class Solution {
    int maxPeople;
    long ans;
    public long minimumFuelCost(int[][] roads, int seats) {
        maxPeople=seats;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<roads.length+1;i++){
            list.add(new ArrayList<>());
        }

         for (int i = 0; i < roads.length; i++) {
            list.get(roads[i][0]).add(roads[i][1]);
            list.get(roads[i][1]).add(roads[i][0]);
        }

        dfs(0,-1,list);
        return ans;
    }

    public int dfs(int i,int prev,List<List<Integer>>list){
         int people = 1;
         for(int x:list.get(i)){
            if(x==prev){
                continue;
            }
            people+=dfs(x,i,list);
         }
         if(i!=0){
            ans+=Math.ceil((double)people/maxPeople);
         }
         return people;
    }
}