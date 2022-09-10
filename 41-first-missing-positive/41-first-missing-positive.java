class Solution {

    public int firstMissingPositive(int[] arr) {
        ////way 1
        //         boolean one = false;

        //         for (int i = 0; i < arr.length; i++) {
        //             if (arr[i] == 1) {
        //                 one = true;
        //             }

        //             if (arr[i] < 1 || arr[i] > arr.length) {
        //                 arr[i] = 1;
        //             }
        //         }
        //         if (one == false) return 1; else {
        //             for (int i = 0; i < arr.length; i++) {
        //                 int index = Math.abs(arr[i]);
        //                 arr[index - 1] = -Math.abs(arr[index - 1]);
        //             }

        //             for (int i = 0; i < arr.length; i++) {
        //                 if (arr[i] > 0) {
        //                     return (i + 1);
        //                 }
        //             }

        //         }
        //         return arr.length+1;
        
        
        //way 2
        Map<Integer,Integer>map=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        
        for(int i=1;i<=arr.length+1;i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
        
        return 0;
    }
}
