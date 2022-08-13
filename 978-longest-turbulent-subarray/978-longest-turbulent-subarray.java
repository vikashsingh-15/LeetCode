class Solution {
    public int maxTurbulenceSize(int[] arr) {
    	// char prev='=';
    	// int ans=0,c=0;
    	// for(int i=0;i<arr.length-1;i++)
    	// {
    	// 	if(arr[i]>arr[i+1])
    	// 	{
    	// 		if(prev=='<')
    	//              c++;
    	// 		else 
    	//              c=1;
    	// 		prev='>';
    	// 	}
    	// 	else if(arr[i]<arr[i+1])
    	// 	{
    	// 		if(prev=='>')
    	//              c++;
    	// 		else 
    	//              c=1;
    	// 		prev='<';
    	// 	}
    	// 	else 
    	// 	{
    	// 		c=0;
    	// 		prev='=';
    	// 	}
    	// 	ans=Math.max(ans, c);
    	// }
    	// return ans+1;
        
        
        int count=0;
        String state="";
        int max=0;
        
        
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                if(state=="inc"){
                    count++;
                }else{
                    count=1;
                }
                state="dec";    
            }
             
            else if(arr[i]<arr[i+1]){
                if(state=="dec"){
                    count++;
                }else{
                    count=1;
                }
                state="inc";
            }
            
            else{
                count=0;
                state="";
            }
            
            max=Math.max(max,count);    
        }
        
        return max+1;
        
        
        
    }
}