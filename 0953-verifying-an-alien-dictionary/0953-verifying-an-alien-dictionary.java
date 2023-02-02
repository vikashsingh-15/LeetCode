class Solution {
    public boolean isAlienSorted(String[] words, String order) {
       HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++){
           map.put(order.charAt(i),i);
       }
        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            int n = Math.min(first.length(), second.length());
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (map.get(first.charAt(j)) < map.get(second.charAt(j))) {
                    flag = true;
                    break;
                }
              else if (map.get(first.charAt(j)) > map.get(second.charAt(j))) {
                    return false;
                }
            }
            if (flag==false && first.length() > second.length()) {
                return false;
            }
        }
        return true;
    }
}