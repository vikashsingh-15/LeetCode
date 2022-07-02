public class Solution {
//     // you need to treat n as an unsigned value
//     public int hammingWeight(int n) {
//         int count = 0;
//     	while(n!=0) {
//     		count = count + (n & 1);
//     		n = n >>> 1; // Unsigned Shift Operation 
//             // System.out.println(n);
//     	}
//     	return count;
//     }


public int hammingWeight(int n) {
        int count =0;
        
        while(n!=0){
            count++;
            System.out.println("Before "+n);
            n&=(n-1); // Brian Kernighan’s Algorithm
            System.out.println("After "+n);
            
        }
        return count;
        
    }
    
}

/*
int counter 0; Brian Kernighan’s Algorithm
while (n != 0)
int rsbm =n & -n;
n-= rsbe;
counter++;*/