class Solution {
    public int[] constructDistancedSequence(int n) {
        int ans[]=new int [n*2 -1];
        HashSet<Integer>set=new HashSet<>();

        helper(0,ans,set,n);
        return ans;
    }

    private boolean helper(int index,int[] ans,HashSet<Integer>set,int n){

        if (index == ans.length) {
            return true;
        }
        if (ans[index] != 0) {
            return helper(index + 1, ans, set, n);
        }

        for(int i=n;i>=1;i--){
            if (set.contains(i)) continue;
           
            if(i==1){
                 ans[index] = i;
                 set.add(i);
                if(helper(index+1,ans,set,n)){
                    return true;
                }else{
                    ans[index]=0;
                    set.remove(i);
                }
            }else{
               
                if(index+i<ans.length && ans[index+i]==0){
                    ans[index] = i;
                    set.add(i);
                    ans[index+i]=i;
                    if(helper(index+1,ans,set,n)){
                        return true;
                    }else{
                        ans[index]=0;
                        ans[index+i]=0;
                        set.remove(i);
                    }
                }
            }
        }
         return false;
    }
}