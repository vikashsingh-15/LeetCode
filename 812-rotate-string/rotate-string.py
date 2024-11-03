class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        if len(goal)!=len(s):
            return False;
        str=s+s;
        return goal in str;
        