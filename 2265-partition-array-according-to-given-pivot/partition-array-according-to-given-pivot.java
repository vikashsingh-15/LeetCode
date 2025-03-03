////way 1 

// class Solution {
//     public int[] pivotArray(int[] nums, int pivot) {
//         int ans[]=new int[nums.length];
//         ArrayList<Integer> list=new ArrayList();
//         int same=0;
//         int small=0;
//         int large=0;

//         for(int num:nums){
//             list.add(num);
//             if(num==pivot){
//                 same++;
//             }
//             else if(num<pivot){
//                 small++;
//             }
//             else{
//                 large++;
//             }
//         }
//         int constSmall=small;
//         int constLarge=large;
//         int constSame=same;

//         for(int num:list){
//             if(num<pivot){
//                 ans[constSmall-(small--)]=num;
//             }
//             if(num==pivot){
//                 ans[constSmall +  constSame-(same--)]=pivot;
//             }

//             if(num>pivot){
//                 ans[constSmall+constSame+constLarge - (large--)]=num;
//             }

//         }
//         return ans;
//     }
// }

////way 2

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int ans[]=new int[nums.length];
        int index=0;
        for(int num:nums){
           if(num<pivot){
            ans[index++]=num;
           }
        }

        for(int num:nums){
           if(num==pivot){
            ans[index++]=num;
           }
        }

         for(int num:nums){
           if(num>pivot){
            ans[index++]=num;
           }
        }
        
        return ans;
    }
}

