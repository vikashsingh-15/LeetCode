class Solution {

    public int totalFruit(int[] fruits) {
        //         //WAY1
        //         int max=0;
        //         int count=0;
        //         int apoint=0;
        //         int bpoint=0;
        //         int arr[]=new int [fruits.length];
        //         for(int i=0;i<fruits.length;i++){
        //             if(arr[fruits[i]]==0){
        //                 count++;
        //             }
        //             arr[fruits[i]]++;
        //             while(count>2){
        //                 arr[fruits[apoint]]--;
        //                 if(arr[fruits[apoint]]==0){
        //                     count--;
        //                 }
        //                 apoint++;
        //             }

        //             max=Math.max(max,i-apoint+1);
        //         }
        //        return max;

        // way2

        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0, j = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            if (map.size() <= 2) {
                maxLen = Math.max(maxLen, i - j + 1);
            }
            while (map.size() > 2) {
                int count = map.get(fruits[j]);
                if (count == 1) {
                    map.remove(fruits[j]);
                } else {
                    map.put(fruits[j], map.get(fruits[j]) - 1);
                }
                j++;
            }
        }
        return maxLen;
    }
}
