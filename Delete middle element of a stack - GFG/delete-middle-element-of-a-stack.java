//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();
            
            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);
                
            }
                Solution obj=new Solution();
                obj.deleteMid(myStack,sizeOfStack);
                
                while(!myStack.isEmpty())
                {
                    System.out.print(myStack.peek()+" ");
                    myStack.pop();
                }
                System.out.println();
        }
        
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{   
 
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
          if (s.isEmpty() || sizeOfStack == 1)
            return;
            int middleIndex=0;
       
         if(sizeOfStack%2==0){
               middleIndex = (sizeOfStack+1) / 2;
              middleIndex++;
         }else{
            middleIndex = (sizeOfStack+1) / 2;  
         }
        // System.out.println(middleIndex);
         deleteMiddleUtil(s, middleIndex);
    } 
    
    public void deleteMiddleUtil(Stack<Integer>s,int current){
        if(current==1){
         s.pop();
         return;
        }
            int temp = s.pop();
            //  System.out.println("Popped out "+ temp);
            //  System.out.println("Current "+ current);
            deleteMiddleUtil(s, current - 1);
        s.push(temp);
    }
}

