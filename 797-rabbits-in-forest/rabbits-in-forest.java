class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer>map=new  HashMap<>();

        for(int num:answers){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int ans=0;

        for(int key:map.keySet()){
            int count = map.get(key);
            int groupSize = key + 1;

            int numberOfGroups = (int) Math.ceil((double) count / groupSize);
            ans += numberOfGroups * groupSize;

        }





        return ans;
        
    }
}