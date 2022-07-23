class Solution {

    public String intToRoman(int num) {
        String roman[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int integer[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String result = "";
        int i = 0;

        while (num > 0 && i < integer.length) {
            if (num >= integer[i]) {
                int n = num / integer[i];
                num = num % integer[i];
                while (n-- > 0) result += roman[i];
            }
            i++;
        }
        return result;
        
        //WAY 2
        
        //         private TreeMap<Integer, String> mp = new TreeMap<>() {{
        // 		put(1, "I");
        // 		put(5, "V");
        // 		put(10, "X");
        // 		put(50, "L");
        // 		put(100, "C");
        // 		put(500, "D");
        // 		put(1000, "M");
        // 		put(4, "IV");
        // 		put(9, "IX");
        // 		put(40, "XL");
        // 		put(90, "XC");
        // 		put(400, "CD");
        // 		put(900, "CM");
        // 	}};

        // public String intToRoman(int num) {
        // 	StringBuilder sb = new StringBuilder();

        // 	while (num > 0) {
        // 		int key = mp.floorKey(num);
        // 		num -= key;
        // 		sb.append(mp.get(key));
        // 	}

        // 	return sb.toString();

        //way 3

        //         StringBuilder ans = new StringBuilder();

        //         int temp;

        //         temp = num / 1000;
        //         help(ans, temp, "M");
        //         num = num % 1000;

        //         temp = num / 900;
        //         help(ans, temp, "CM");
        //         num = num % 900;

        //         temp = num / 500;
        //         help(ans, temp, "D");
        //         num = num % 500;

        //         temp = num / 400;
        //         help(ans, temp, "CD");
        //         num = num % 400;

        //         temp = num / 100;
        //         help(ans, temp, "C");
        //         num = num % 100;

        //         temp = num / 90;
        //         help(ans, temp, "XC");
        //         num = num % 90;

        //         temp = num / 50;
        //         help(ans, temp, "L");
        //         num = num % 50;

        //         temp = num / 40;
        //         help(ans, temp, "XL");
        //         num = num % 40;

        //         temp = num / 10;
        //         help(ans, temp, "X");
        //         num = num % 10;

        //         temp = num / 9;
        //         help(ans, temp, "IX");
        //         num = num % 9;

        //         temp = num / 5;
        //         help(ans, temp, "V");
        //         num = num % 5;

        //         temp = num / 4;
        //         help(ans, temp, "IV");
        //         num = num % 4;

        //         temp = num / 1;
        //         help(ans, temp, "I");

        //         // System.out.println(ans.toString());
        //         return ans.toString();

    }
    //        public void help(StringBuilder ans, int temp, String a) {
    //         while (temp != 0) {
    //             ans.append(a);
    //             temp--;
    //         }
    //     }
}
