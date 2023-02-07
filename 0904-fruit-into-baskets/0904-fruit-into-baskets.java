class Solution {
    public int totalFruit(int[] fruits) {
        int max=0;
        int count=0;
        int apoint=0;
        int bpoint=0;
        int arr[]=new int [fruits.length];
        for(int i=0;i<fruits.length;i++){
            if(arr[fruits[i]]==0){
                count++;
            }
            arr[fruits[i]]++;
            while(count>2){
                arr[fruits[apoint]]--;
                if(arr[fruits[apoint]]==0){
                    count--;
                }
                apoint++;
            }
            
            max=Math.max(max,i-apoint+1);
        }
       return max; 
    }
}