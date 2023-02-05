class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] != "-1") {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                // System.out.println("Checked at " + i);
                for (int j = i ; j < strs.length; j++) {
                    if ( i!=j && strs[j]!= "-1" && isvalidAnagram(strs[i], strs[j])) {
                        list.add(strs[j]);
                        strs[j] = "-1";
                    }
                }
                ans.add(list);
                // System.out.println(ans.toString());
            }
        }

        // if (strs[strs.length - 1] != "-1") {
        //     ans.add(strs[strs.length - 1]);
        // }
        return ans;
    }

    public boolean isvalidAnagram(String s, String t) {
        // System.out.println("String 1 "+s);
        // System.out.println(" string 2 "+t);
        if (s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            a[t.charAt(i) - 'a']--;
        }
        for (int j = 0; j < 26; j++) {
            if (a[j] != 0) return false;
        }
        return true;
    }
}
