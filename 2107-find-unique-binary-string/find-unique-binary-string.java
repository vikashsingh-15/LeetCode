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

        generate(n, "");

        for (String s : result) {
            boolean found = false;

            for (String num : nums) {
                if (num.equals(s)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return s;
            }
        }

        return "";
    }
}