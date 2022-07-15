class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int sol[]=new int[nums1.length];
        
        for(int i=0;i<nums1.length;i++){
            int count=0;
            for(int j=0;j<nums2.length;j++){
                if(nums2[j]==nums1[i]){
                    for(int k=j+1;k<nums2.length;k++){
                        if(nums2[k]>nums1[i]){
                           sol[i]=nums2[k];
                            break;
                        }
                    }
                    
                    if(sol[i]==0){
                        sol[i]=-1;
                    }
                }
            }
            
            // if(count>0){sol[i]=count;}
            // sol[i]=-1;
        }
        
        return sol;
       
        
    }
}