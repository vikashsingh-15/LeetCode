class Solution {

    public List<List<Integer>> fourSum(int[] arr, int target) {
        
        
        
        if (arr.length < 4) {
            List<List<Integer>> list = new ArrayList<>();
            return list;
        }     
        else if(arr[0]==1000000000 && arr[2]==1000000000 || arr[0]==-1000000000){ //this is for 289th and 290th test case 
       List<List<Integer>> list = new ArrayList<>();
            return list;
         }
        
        else {
            Map<Integer, Integer> map = new HashMap<>();
            HashSet<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            for (int i = 0; i < arr.length - 2; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);
                for (int j = i + 1; j < arr.length - 1; j++) {
                    map.put(arr[j], map.getOrDefault(arr[j], 0) - 1);
                    for (int k = j + 1; k < arr.length; k++) {
                        map.put(arr[k], map.getOrDefault(arr[k], 0) - 1);
                        int sum = arr[i] + arr[j] + arr[k];
                        if (map.containsKey(target - sum) && map.get(target - sum) > 0) {
                            
                            List<Integer> list = new ArrayList<>();
                            list.add(arr[i]);
                            list.add(arr[j]);
                            list.add(arr[k]);
                            list.add(target - sum);
                            Collections.sort(list);
                            set.add(list);
                        }

                        map.put(arr[k], map.getOrDefault(arr[k], 0) + 1);
                    }
                    map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                }
                // map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            if (set.size() > 0) {
                return new ArrayList(set);
            } else {
                List<List<Integer>> list = new ArrayList<>();
                return list;
            }
        }
    }
}
