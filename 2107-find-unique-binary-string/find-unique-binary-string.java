// class Solution {

//     public String findDifferentBinaryString(String[] nums) {
//         StringBuilder sb = new StringBuilder();

//         for (int i = 0; i < nums.length; i++) {
//             sb.append(nums[i].charAt(i) == '0' ? "1" : "0");
//         }
//         return new String(sb);
//     }
// }

////way 2

// class Solution {

//     public String findDifferentBinaryString(String[] nums) {
//         int n = nums.length;
//         Set<Integer> set = new HashSet<>();
//         String binaryString = "";
//         for (String num : nums) {
//             int decimalValue = Integer.parseInt(num, 2);
//             set.add(decimalValue);
//         }

//         for (int i = 0; i <= 16; i++) {
//             if (set.contains(i)) {
//                 continue;
//             } else {
//                 binaryString = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
//                 break;
//             }
//         }

//         return binaryString;
//     }
// }


////Way 3

// class Solution {
//     public String findDifferentBinaryString(String[] nums) {
//         int n=nums[0].length();
//         ArrayList<String>list=new ArrayList<>();
//          HashSet<String> set = new HashSet<>();
//         for (String num : nums) {
//             set.add(num);
//         }
//         helper(n, new StringBuilder(),list);

//         for (String binary : list) {
//             if (!set.contains(binary)) {
//                 return binary;
//             }
//         }

//         return "";
//     }

//     public void helper(int n,StringBuilder current,ArrayList<String>list){
//          if (current.length() == n) {
//             list.add(current.toString());  // Add to the list
//             return;
//         }
         
//         helper(n,current.append(0),list);
//         current.deleteCharAt(current.length() - 1);

//         helper(n,current.append(1),list);
//         current.deleteCharAt(current.length() - 1);
//     }
// }

////way 4

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        HashSet<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }

        ArrayList<String> list = new ArrayList<>();
        generateBinaryStrings(n, "", list);

        // Find a string that is not in the original set
        for (String binary : list) {
            if (!set.contains(binary)) {
                return binary;
            }
        }

        return "";  // This line should never be reached
    }

    public void generateBinaryStrings(int n, String current, ArrayList<String> list) {
        if (current.length() == n) {
            list.add(current);
            return;
        }

        generateBinaryStrings(n, current + "0", list);
        generateBinaryStrings(n, current + "1", list);
    }
}
