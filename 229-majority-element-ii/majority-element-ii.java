class Solution {

    public List<Integer> majorityElement(int[] arr) {
        
        //way 1
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

                count1 = 0;
                count2 = 0;

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

 // way 2

        //         int n = arr.length / 3;
        //         Arrays.sort(arr);
        //         int count = 1;
        //         ArrayList<Integer> list = new ArrayList();
        //         for (int i = 0; i < arr.length; i++) {
        //             if (i < arr.length - 1 && arr[i] == arr[i + 1]) {
        //                 count = count + 1;
        //             }
        //             if (i < arr.length - 1 && arr[i] != arr[i + 1]) {
        //                 count = 1;
        //             }
        //             if (count > n) {
        //                 list.add(arr[i]);
        //                 count = 1;
        //             }
        //         }
        //         Set<Integer> set = new LinkedHashSet<>();

        //         set.addAll(list);
        //         list.clear();
        //         list.addAll(set);
        //         return list;

//way 3

        //   List<Integer> ans = new ArrayList<Integer>();
        // Arrays.sort(arr);
        //   for (int i = 0; i < arr.length; i++)
        //   {
        //       int count = 1;
        //         while (i < arr.length-1 && arr[i] == arr[i + 1]) {
        //           i++;
        //           count++;
        //       }
        //     if(count>arr.length/3) ans.add(arr[i]);
        //   }
        // return ans;

// //way 4
//         List<Integer> al = new ArrayList<>();
//         int n = arr.length;
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int i : arr) {
//             map.put(i, map.getOrDefault(i, 0) + 1);
//         }
//         for (int i : map.keySet()) {
//             if (map.get(i) > n / 3) al.add(i);
//         }
//         return al;
    }
}