class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
         // LinkedList<List<Integer>> list = new LinkedList<>(); // this will also work
        List<Integer> pre = null; 
        //List<Integer> pre = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> current = new LinkedList<>();
            // LinkedList<Integer> current = new LinkedList<>(); //-- will work
             // List<Integer> current = new LinkedList<>(); //-- will work
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    current.add(1);
                } else {
                    current.add(pre.get(j - 1) + pre.get(j));
                }
            }

            pre = current;
            list.add(current);
        }
        return list;
    }
}
