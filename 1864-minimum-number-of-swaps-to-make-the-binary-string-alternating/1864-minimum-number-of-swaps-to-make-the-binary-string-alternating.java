class Solution {
    public int minSwaps(String str) {
       int count0 = 0;
        int count1 = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '0') {
                count0++;
            } else if (c == '1') {
                count1++;
            }
        }
        if (Math.abs(count0 - count1) > 1) {
            return -1;
        } else {
            // 1 at first
            int i = 0;
            int cost1 = 0;
            while (i < str.length()) {
                if (i % 2 == 0) {
                    if (str.charAt(i) != '1') {
                        cost1++;
                    }
                } else {
                    if (str.charAt(i) != '0') {
                        cost1++;
                    }
                }
                i++;
            }

            // 0 at first
            int j = 0;
            int cost0 = 0;
            while (j < str.length()) {
                if (j % 2 == 0) {
                    if (str.charAt(j) != '0') {
                        cost0++;
                    }
                } else {
                    if (str.charAt(j) != '1') {
                        cost0++;
                    }
                }
                j++;
            }

            if (cost0 % 2 == 0 && cost1 % 2 == 0) {
                if (cost0 / 2 < cost1 / 2) {
                    return cost0 / 2;
                  
                } else {
                    return cost1 / 2;
               
                }
            }

            else {
                if (cost0 % 2 == 0)
                    return cost0 / 2;
                   
                else
                    return cost1 / 2;
                  
            }  
    }
    }
}
