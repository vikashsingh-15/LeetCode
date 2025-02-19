// class Solution {
//     public String getHappyString(int n, int k) {

//         ArrayList<String> str = new ArrayList<>();
//         ArrayList<ArrayList<String>> list = new ArrayList<>();

//         helper(0, n, str, list);
//         if (k > list.size()) {
//             return "";
//         }
//           StringBuilder result = new StringBuilder();
//         for (String ch : list.get(k - 1)) {  
//             result.append(ch);
//         }
//         return result.toString();
//     }

//     public void helper(int index, int n, ArrayList<String> current, ArrayList<ArrayList<String>> list) {
//         if (current.size() == n) {
//             list.add(new ArrayList<>(current));
//             return;
//         }
//         String chars = "abc";

//         for (int i = 0; i < chars.length(); i++) {
//             char c = chars.charAt(i);

//             if (current.isEmpty() || current.get(current.size() - 1).charAt(0) != c) {
//                 current.add(String.valueOf(c));
//                 helper(index + 1, n, current, list);
//                 current.remove(current.size() - 1);
//             }

//         }
//     }

// }


////

// import java.util.ArrayList;

// class Solution {
//     public String getHappyString(int n, int k) {
//         ArrayList<String> list = new ArrayList<>();
//         helper(0, n, new StringBuilder(), list);
//         if (k > list.size()) {
//             return "";
//         }
//         return list.get(k - 1);
//     }

//     public void helper(int index, int n, StringBuilder current, ArrayList<String> list) {
//         if (current.length() == n) {
//             list.add(current.toString());
//             return;
//         }

//         String chars = "abc";
//         for (int i = 0; i < chars.length(); i++) {
//             char c = chars.charAt(i);
//             if (current.length() == 0 || current.charAt(current.length() - 1) != c) {
//                 current.append(c);
//                 helper(index + 1, n, current, list);
//                 current.deleteCharAt(current.length() - 1);
//             }
//         }
//     }
// }

////way 3


import java.util.ArrayList;

class Solution {
    public String getHappyString(int n, int k) {
        ArrayList<String> list = new ArrayList<>();
        helper(0, n, new StringBuilder(), list,k);
        if (k > list.size()) {
            return "";
        }
        return list.get(k - 1);
    }

    public void helper(int index, int n, StringBuilder current, ArrayList<String> list,int k) {
        if (current.length() == n) {
            list.add(current.toString());
            return;
        }
        if(list.size()>k){
            return;
        }

        String chars = "abc";
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (current.length() == 0 || current.charAt(current.length() - 1) != c) {
                current.append(c);
                helper(index + 1, n, current, list,k);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}
