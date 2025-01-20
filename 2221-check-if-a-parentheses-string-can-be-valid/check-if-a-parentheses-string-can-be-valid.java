class Solution {
    public boolean canBeValid(String s, String locked) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }

        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                openBrackets.push(i);
            } else if (s.charAt(i) == ')') {
                if (!openBrackets.isEmpty()) {
                    openBrackets.pop();
                } else if (!unlocked.empty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }
        while (!openBrackets.empty() &&!unlocked.empty() && openBrackets.peek() < unlocked.peek()) {
            openBrackets.pop();
            unlocked.pop();
        }

        if (!openBrackets.empty()) {
            return false;
        }

        if (!unlocked.empty() && unlocked.size()%2!=0) {
            return false;
        }

        return true;

    }
}