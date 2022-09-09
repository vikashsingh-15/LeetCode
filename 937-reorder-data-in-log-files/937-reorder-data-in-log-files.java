class Solution {

    public String[] reorderLogFiles(String[] logs) {
        String ans[] = new String[logs.length];
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            if (isLetterLog(logs[i])) {
                letters.add(logs[i]);
            } else {
                digits.add(logs[i]);
            }
        }
        
        letters.sort(this::compare);
        
        List<String> result = new ArrayList<>();
        for (String str : letters) {
            result.add(str);
        }
        
        for(String str : digits) {
            result.add(str);
        }
        
        String[] res = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        
        return res;
    }
    
    private int compare(String a, String b) {
        String[] as = a.split(" ", 2);
        String[] bs = b.split(" ", 2);
        int val = as[1].compareTo(bs[1]);
        if (val != 0) {
            return val;
        }
        return as[0].compareTo(bs[0]);
    }

    public boolean isLetterLog(String str) {
        String[] strs = str.split(" ");
        if (Character.isDigit(strs[1].charAt(0))) {
            return false;
        } else {
            return true;
        }
    }
}
