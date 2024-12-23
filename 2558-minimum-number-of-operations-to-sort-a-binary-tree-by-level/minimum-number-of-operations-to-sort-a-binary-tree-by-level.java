
//// This is wrong thought and process
// class Solution {
// public int minimumOperations(TreeNode root) {
// Queue<TreeNode>queue=new LinkedList<>();
// queue.add(root);
// int totalSwap=0;
// while(!queue.isEmpty()){
// int levelSize=queue.size();
// int levelValue[]=new int[levelSize];
// for(int i=0;i<levelSize;i++){
// TreeNode node=queue.poll();
// levelValue[i]=node.val;
// if(node.left!=null) queue.add(node.left);
// if(node.right!=null) queue.add(node.right);
// }
// int [] tempArr=levelValue.clone();
// Arrays.sort(tempArr);
// int count=0;

// for(int i=0;i<tempArr.length;i++){
// if(tempArr[i]!=levelValue[i]){
// count++;
// }
// }
// totalSwap+=(int) Math.round(count / 2.0);
// }
// return totalSwap;
// }
// }

class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int totalSwap = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelValue[] = new int[levelSize];
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelValue[i] = node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            totalSwap += getMinSwaps(levelValue);
        }
        return totalSwap;
    }

    private int getMinSwaps(int[] arr) {
        int swap = 0;
        int[] target = arr.clone();
        Arrays.sort(target);

        Map<Integer, Integer> pos = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            pos.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) {
                swap++;
                int curPos = pos.get(target[i]);
                pos.put(arr[i], curPos);
                arr[curPos] = arr[i];
                arr[i]=target[i];
            }
        }
        return swap;
    }
}