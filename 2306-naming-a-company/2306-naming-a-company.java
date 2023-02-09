class Solution {

    public long distinctNames(String[] ideas) {
        Set<String>[] set = new Set[26];
        for(int i=0;i<26;i++){
            set[i] = new HashSet<>();
        }
        for(String idea : ideas){
            set[idea.charAt(0) - 'a'].add(idea.substring(1));
        }
        long pair = 0;
        for(int i=0;i<25;i++){
            for(int j=i+1;j<26;j++){
                int overlapping = 0;
                for(String s : set[i]){
                    if(set[j].contains(s)){
                        overlapping++;
                    }
                }
                pair = pair + (set[i].size() - overlapping) * (set[j].size() - overlapping) * 2;
            }
        }
        return pair;
    }
}


