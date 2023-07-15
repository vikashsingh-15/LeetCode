class Solution {
    public String simplifyPath(String path) {
        //   String[] paths = path.split("/");
        // int left = -1, right = 0;
        // while (right < paths.length) {
        // 	if (paths[right].equals(".."))
        // 		left = left == -1 ? -1 : left - 1;
        // 	else if (!paths[right].equals(".") && !paths[right].equals(""))
        // 		paths[++left] = paths[right];
        // 	right++;
        // }
        // if (left == -1)
        // 	return "/";
        // StringBuilder buf = new StringBuilder();
        // for (int i = 0; i <= left; i++)
        // 	buf.append('/').append(paths[i]);
        // return buf.toString();
        
        
        //way 2
        
        Stack<String>stack=new Stack<>();
        String[] directories = path.split("/"); 
        for(String dir:directories){
            if(dir.equals(".") || dir.isEmpty())continue;
            else if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(dir);
            }
        }
        
        return "/" + String.join("/", stack); 
        
        }
}