public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){
        int requiredNum = target - numbers[i];
            if(map.containsKey(requiredNum)){
                int toReturn[] = {map.get(requiredNum), i};
                return toReturn;
            }

            map.put(numbers[i], i);
        }
        return null;
    }
}