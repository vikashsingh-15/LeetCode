class Solution {
    public int romanToInt(String s) {
        
      HashMap<String, Integer> alphabet = new HashMap<String, Integer>();
        alphabet.put("I", 1);
        // alphabet.put("IV", 4);
        alphabet.put("V", 5);
        // alphabet.put("IX", 9);
        alphabet.put("X", 10);
        // alphabet.put("XL", 40);
        alphabet.put("L", 50);
        // alphabet.put("XC", 90);
        alphabet.put("C", 100);
        // alphabet.put("CD", 400);
        alphabet.put("D", 500);
        // alphabet.put("CM", 900);
        alphabet.put("M", 1000);
        int result = 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (alphabet.get(Character.toString(s.charAt(i))) < alphabet.get(Character.toString(s.charAt(i + 1))))
                result = result - alphabet.get(Character.toString(s.charAt(i)));
            else 
                result = result + alphabet.get(Character.toString(s.charAt(i)));
        }
        return result + alphabet.get(Character.toString(s.charAt(s.length() - 1)));
    }       
        
    }