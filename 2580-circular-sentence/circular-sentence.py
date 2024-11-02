class Solution:
    def isCircularSentence(self, s: str) -> bool:
        arr=s.split();
        if( arr[0][0]!=arr[len(arr) - 1][-1]):
            return False;

        for i in range(1,len(arr)):
            if arr[i-1][-1]!=arr[i][0]:
                return False;
        return True;
            



        