class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> stk=new Stack<>();
        
        int sol []=new int [nums1.length];   
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            map.put(nums2[i],i);
        }  
        for(int i=0;i<nums1.length;i++){
            int pos=map.get(nums1[i]);
             stk=new Stack<>();
             stk.push(nums2[nums2.length-1]);
            
            for(int j=nums2.length-1; j>=pos; j--){
                while(stk.size()>0 && stk.peek()<=nums1[i]){
                    stk.pop();
                }
                if(stk.size()==0){
                    sol[i]=-1;
                }
                else{
                    sol[i]=stk.peek();
                } 
                stk.push(nums2[j]);
            }
        }
        
        return sol;
        
        
        
        
        
        
//         int sol[] = new int[nums1.length];
//         for (int i = 0; i < nums1.length; i++) {
//             int count = 0;
//             for (int j = 0; j < nums2.length; j++) {
//                 if (nums2[j] == nums1[i]) {
//                     for (int k = j + 1; k < nums2.length; k++) {
//                         if (nums2[k] > nums1[i]) {
//                             sol[i] = nums2[k];
//                             break;
//                         }
//                     }

//                     if (sol[i] == 0) {
//                         sol[i] = -1;
//                     }
//                 }
//             }
//         }

//         return sol;
        
        
        
        
        
        
        
    }
}
