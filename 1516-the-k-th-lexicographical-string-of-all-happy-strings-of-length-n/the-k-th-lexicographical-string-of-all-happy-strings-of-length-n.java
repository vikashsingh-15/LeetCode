class Solution {
    public String getHappyString(int n, int k) {

        ArrayList<String> str = new ArrayList<>();
        ArrayList<ArrayList<String>> list = new ArrayList<>();

        helper(0, n, str, list);
        if (k > list.size()) {
            return "";
        }
          StringBuilder result = new StringBuilder();
        for (String ch : list.get(k - 1)) {  
            result.append(ch);
        }
        return result.toString();
    }

    public void helper(int index, int n, ArrayList<String> current, ArrayList<ArrayList<String>> list) {
        if (current.size() == n) {
            list.add(new ArrayList<>(current));
            return;
        }
        String chars = "abc";

        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);

            if (current.isEmpty() || current.get(current.size() - 1).charAt(0) != c) {
                current.add(String.valueOf(c));
                helper(index + 1, n, current, list);
                current.remove(current.size() - 1);
            }

        }
    }

}
