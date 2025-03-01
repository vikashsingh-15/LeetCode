// class Solution {
//     public int[] applyOperations(int[] arr) {
//         int n=arr.length;
//         Queue<Integer>queue=new LinkedList<>();

//         for(int i=0;i<n-1;i++){
//             if(arr[i]==arr[i+1] && arr[i]!=0){
//                 arr[i]*=2;
//                 arr[i+1]=0;
//             }

//             if(arr[i]!=0){
//                 queue.add(arr[i]);
//             }
//         }

//         if(arr[n-1]!=0){
//             queue.add(arr[n-1]);
//         }

//         int index=0;
//         while(!queue.isEmpty()){
//             arr[index++]=queue.poll();
//         }

//         while(index<n){///after queue is over we  cant left arr as it is we have to set it 0 
//              arr[index++]=0;
//         }

//         return arr;
        
//     }
// }


////way 2

class Solution {
    public int[] applyOperations(int[] arr) {
        int n=arr.length;
        int index=0;
        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1] && arr[i]!=0){
                arr[i]*=2;
                arr[i+1]=0;
            }

            if(arr[i]!=0){
                arr[index++]=arr[i];
            }
        }

        if(arr[n-1]!=0){
            arr[index++]=arr[n-1];
        }

       while(index<n){
         arr[index++]=0;
       }

        return arr;
        
    }
}