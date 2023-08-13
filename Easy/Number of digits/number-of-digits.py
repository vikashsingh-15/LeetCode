#User function Template for python3

class Solution:
    def noOfDigits(self, N):
        if N <= 1:
            return 1
        
        prev, curr = 0, 1
        for i in range(2, N+1):
            next_fib = prev + curr
            prev = curr
            curr = next_fib
        
        return len(str(curr))

    


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        N = int(input())
       

        ob = Solution()
        print(ob.noOfDigits(N))
# } Driver Code Ends