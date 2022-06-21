class Solution {
    public int furthestBuilding(int[] arr, int bricks, int ladders) {
        
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
         // PriorityQueue<Integer> pQueue= new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i=0;i<arr.length-1;i++){
            int diff=arr[i+1]-arr[i];  
            if(diff>0){
                queue.add(diff);
            }
            if(queue.size()>ladders){
                bricks-=queue.poll();
            }
            if(bricks<0){
                return i;
            }
        }   
         
        
        return arr.length-1;
        }
        
    }
