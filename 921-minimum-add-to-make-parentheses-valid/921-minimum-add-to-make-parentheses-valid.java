class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack();
        int count = 0;
        for(int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if(ch == '(') {
                stack.push(ch);
            } else if(ch == ')') {
                if(stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }
        
        return stack.size()+count;
        // while(!stack.isEmpty()) {
        //     stack.pop();
        //     count++;
        // }
        // return count;
    }
}