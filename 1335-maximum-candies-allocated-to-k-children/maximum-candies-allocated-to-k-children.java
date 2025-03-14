//Traditional Binary

// class Solution {
//     public int maximumCandies(int[] arr, long k) {
//         int max=0;
//         for(int i=0;i<arr.length;i++){
//             max=Math.max(arr[i],max);
//         }

//         int left=1;
//         int right=max;

//         while(left<=right){
//            int  mid = left + (right - left) / 2;
//             if(helper(arr,k,mid)){
//                 left=mid+1;
//             }else{
//                 right=mid-1;
//             }
//         }
//         return right;  
//     }

//     private boolean helper(int arr[],long k,int numOfCandies){

//          long maxNumOfChildren = 0;
//         for(int i=0;i<arr.length;i++){
//              maxNumOfChildren +=arr[i]/numOfCandies;
//         }

//         return maxNumOfChildren>=k;
//     }
// }

/**
Let's say left = mid, and right = mid - 1.
If mid is already equal to left, then:

left does not increase.
right keeps decreasing.
This creates a situation where the loop does not terminate properly.
left = 5, right = 6
mid = (5 + 6) / 2 = 5

 */
//way 2

class Solution {

    public int maximumCandies(int[] candies, long k) {
        int maxCandiesInPile = 0;
        for (int i = 0; i < candies.length; i++) {
            maxCandiesInPile = Math.max(maxCandiesInPile, candies[i]);
        }
        int left = 0;
        int right = maxCandiesInPile;
        while (left < right) {
            int middle = (left + right + 1) / 2;
            if (canAllocateCandies(candies, k, middle)) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }

        return right;
    }

    private boolean canAllocateCandies(
        int[] candies,
        long k,
        int numOfCandies
    ) {
        long maxNumOfChildren = 0;
        for (int pileIndex = 0; pileIndex < candies.length; pileIndex++) {
            maxNumOfChildren += candies[pileIndex] / numOfCandies;
        }

        return maxNumOfChildren >= k;
    }
}