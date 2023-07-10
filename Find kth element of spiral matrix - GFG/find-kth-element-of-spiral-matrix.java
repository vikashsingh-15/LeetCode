//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k){
        
       int rowStart=0;
       int colStart=0;
       int rowEnd=n-1;
       int colEnd=m-1;
       int total=n*m;
       int count=0;
         if (k > total) {
            return -1; 
        }
       while(count<k){
           if(count<total){
               for(int i=colStart;i<=colEnd;i++){
                   count++;
                   if(count==k){
                       return A[rowStart][i];
                   }
               }
               rowStart++;
           }
           
           
            if(count<k){
               for(int i=rowStart;i<=rowEnd;i++){
                   count++;
                   if(count==k){
                       return A[i][colEnd];
                   }
               }
               colEnd--;
           }
           
           
            if(count<k){
               for(int i=colEnd;i>=colStart;i--){
                   count++;
                   if(count==k){
                       return A[rowEnd][i];
                   }
               }
               rowEnd--;
           }
           
            if(count<k){
               for(int i=rowEnd;i>=rowStart;i--){
                   count++;
                   if(count==k){
                       return A[i][colStart];
                   }
               }
               colStart++;
           }
       }
       
       return -1;
        	
    }
}