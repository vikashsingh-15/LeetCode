
class Solution {
    public String getHappyString(int n, int k) {
        ArrayList<String> list = new ArrayList<>();
        helper(n, new StringBuilder(), list,k);
        if (k > list.size()) {
            return "";
        }
        return list.get(k - 1);
    }

    public void helper( int n, StringBuilder current, ArrayList<String> list,int k) {
        if (current.length() == n) {
            list.add(current.toString());
            return;
        }
        if(list.size()>k){
            return;
        }

        String chars = "abc";
        for (int i = 0; i < chars.length(); i++) {
            char ch=chars.charAt(i);

           if(current.length()==0 || current.charAt(current.length()-1)!=ch){
            current.append(ch);
            helper(n,current,list,k);
            current.deleteCharAt(current.length()-1);
           }
        }
    }
}
