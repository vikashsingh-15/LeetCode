// class Solution {

//     public String findDifferentBinaryString(String[] nums) {
//         StringBuilder sb = new StringBuilder();

//         for (int i = 0; i < nums.length; i++) {
//             sb.append(nums[i].charAt(i) == '0' ? "1" : "0");
//         }
//         return new String(sb);
//     }
// }

class Solution {

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        String binaryString = "";
        for (String num : nums) {
            int decimalValue = Integer.parseInt(num, 2);
            set.add(decimalValue);
        }

        for (int i = 0; i <= 16; i++) {
            if (set.contains(i)) {
                continue;
            } else {
                binaryString = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
                break;
            }
        }

        return binaryString;
    }
}
