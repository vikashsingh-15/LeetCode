class Solution {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] arr, int[][] queries) {
        Map<Integer,List<Integer>>map=new HashMap<>();

       for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i][0], k -> new ArrayList<>());
            map.get(arr[i][0]).add(arr[i][1]);
        }

        List<Boolean> result = new ArrayList<>();

        for(int i=0;i<queries.length;i++){
            boolean[] visited = new boolean[numCourses];
            result.add(dfs(map, visited, queries[i][0], queries[i][1]));
        }

        return result;
    }

    public boolean dfs( Map<Integer,List<Integer>>map,boolean visited[],int src, int target){
        
        if(src==target){
            return true;
        }

        visited[src]=true;

        boolean ans=false;

        List<Integer>paths=map.getOrDefault(src,new ArrayList<>());

        for(int path:paths){
            if(!visited[path]){
                ans=ans || dfs(map, visited, path, target);
            }
        }

        return ans;

    }
}