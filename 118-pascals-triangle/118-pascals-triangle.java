class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> pre = null;
        for(int i=0;i<numRows;i++){
            List<Integer> current=new ArrayList<>();
            
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    current.add(1);
                }
                else{
                    current.add(pre.get(j-1)+pre.get(j));
                }
            }
            
            pre=current;
            list.add(current);
        }
        return list;
        
    }
}