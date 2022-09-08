class Solution {

    public List<Integer> majorityElement(int[] arr) {
        int val1 = arr[0];
        int count1 = 1;

        int val2 = arr[0];
        int count2 = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == val1) {
                count1++;
            } else if (arr[i] == val2) {
                count2++;
            } else {
                if (count1 == 0) {
                    val1 = arr[i];
                    count1++;
                } else if (count2 == 0) {
                    val2 = arr[i];
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int desti = arr.length / 3;
        
        count1=0;
        count2=0;

        for (int i = 0; i < arr.length; i++) {
            if (val1 == arr[i]) {
                count1++;
            }
            if (val2 == arr[i]) {
                count2++;
            }
        }

        if (count1 > desti) {
            list.add(val1);
        }
        if ((val1 != val2) && (count2 > desti)) {
            list.add(val2);
        }

        return list;
    }
}
