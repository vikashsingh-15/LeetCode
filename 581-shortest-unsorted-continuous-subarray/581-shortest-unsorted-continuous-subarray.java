class Solution {

    public int findUnsortedSubarray(int[] arr) {
        // int ans[]=new int[2];

        int apoint = -1;
        int bpoint = -1;
        int max = arr[0];
        int min = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < max) {
                bpoint = i;
            } else {
                max = arr[i];
            }
        }

        for (int i = arr.length-2; i >=0; i--) {
            if (arr[i] > min) {
                apoint = i;
            } else {
                min = arr[i];
            }
        }

         if(apoint==bpoint){
            return 0;
        }else{
           return bpoint-apoint+1;
        }
    }
}
