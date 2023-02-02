class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList < Integer > list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys, (o1, o2) -> map.get(o2) - map.get(o1));
        
    
            int arr[]=new int[k];
             for (int i = 0; i <k; i++) {
                arr[i]=(int)keys[i];
             }
                 return arr;
        
    }
}
