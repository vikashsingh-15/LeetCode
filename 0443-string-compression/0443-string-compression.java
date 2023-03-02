class Solution {

    public int compress(char[] chars) {
        ////way 1
        //         if (chars == null || chars.length == 0) {
        //             return 0;
        //         }
        //         int writeIndex = 0;
        //         char prevChar = chars[0];
        //         int count = 1;
        //         for (int i = 1; i < chars.length; i++) {
        //             if (chars[i] == prevChar) {
        //                 count++;
        //             } else {
        //                 chars[writeIndex++] = prevChar;
        //                 if (count > 1) {
        //                     String countStr = Integer.toString(count);
        //                     for (int j = 0; j < countStr.length(); j++) {
        //                         chars[writeIndex++] = countStr.charAt(j);
        //                     }
        //                 }
        //                 prevChar = chars[i];
        //                 count = 1;
        //             }
        //         }
        //         chars[writeIndex++] = prevChar;
        //         if (count > 1) {
        //             String countStr = Integer.toString(count);
        //             for (int j = 0; j < countStr.length(); j++) {
        //                 chars[writeIndex++] = countStr.charAt(j);
        //             }
        //         }

        //         return writeIndex;

        ////WAY 2
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int apoint = 0;
        int count = 1;
        char prev = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];
            if (current == prev) {
                count += 1;
            } else {
                chars[apoint++] = prev;
                if (count > 1) {
                    String countStr = Integer.toString(count);
                    for (int j = 0; j < countStr.length(); j++) {
                        chars[apoint++] = countStr.charAt(j);
                    }
                }
                prev = current;
                count = 1;
            }
        }
        chars[apoint++] = prev;
        if (count > 1) {
            String countStr = Integer.toString(count);
            for (int j = 0; j < countStr.length(); j++) {
                chars[apoint++] = countStr.charAt(j);
            }
        }
        return apoint;
    }
}
