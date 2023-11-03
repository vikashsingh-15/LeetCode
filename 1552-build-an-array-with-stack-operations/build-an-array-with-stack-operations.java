class Solution {
    public List<String> buildArray(int[] target, int n) {

        int current=1;
        List<String> list=new ArrayList<>();
        for(int i=0;i<target.length;i++){
            while(current!=target[i]){
                list.add("Push");
                list.add("Pop");
                current++;
            }

            list.add("Push");
            current++;
        }

        return list;
    }
}