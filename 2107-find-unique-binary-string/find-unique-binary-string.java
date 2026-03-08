import java.util.*;

class Solution {

    Set<String> result = new HashSet<>();

    public void generate(int n, String current) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        generate(n, current + "0");
        generate(n, current + "1");
    }

    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;

        result.clear();

        generate(n, "");

        for (String s : nums) {
            result.remove(s);   
        }

        // return any remaining string
        return result.iterator().next();
    }
}