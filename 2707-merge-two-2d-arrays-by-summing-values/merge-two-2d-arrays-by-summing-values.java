import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> mergedList = new ArrayList<>();

        int apoint = 0, bpoint = 0;

        while (apoint < nums1.length && bpoint < nums2.length) {
            if (nums1[apoint][0] == nums2[bpoint][0]) {
                int[] mergedElement = new int[2];
                mergedElement[0] = nums1[apoint][0]; // Assign the index
                mergedElement[1] = nums1[apoint][1] + nums2[bpoint][1]; // Assign the summed value
                mergedList.add(mergedElement);

                apoint++;
                bpoint++;
            } else if (nums1[apoint][0] < nums2[bpoint][0]) {
                mergedList.add(nums1[apoint]);
                apoint++;
            } else {
                mergedList.add(nums2[bpoint]);
                bpoint++;
            }
        }

        while (apoint < nums1.length) {
            mergedList.add(nums1[apoint++]);
        }

        while (bpoint < nums2.length) {
            mergedList.add(nums2[bpoint++]);
        }

        int size = mergedList.size();
        int[][] resultArray = new int[size][];
        for (int i = 0; i < size; i++) {
            resultArray[i] = mergedList.get(i);
        }
        return resultArray;

    }
}
