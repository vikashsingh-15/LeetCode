/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// class Solution {
//      Node[] copyNodes = new Node[100];

//     public Node cloneGraph(Node node){
//         if (node == null) return null;
//         int ind = node.val-1;
//         if (copyNodes[ind] == null){
//             copyNodes[ind] = new Node(node.val);
//             for (Node neighbor : node.neighbors)
//                 copyNodes[ind].neighbors.add(cloneGraph(neighbor));
//         }
//         return copyNodes[ind];
//     }
// }

// DFS
class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node newNode = new Node(node.val);
        // or
        //Node newNode=new Node(node.val,new ArrayList<>());
        visited.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }
}
// BFS
// class Solution {
//     public Node cloneGraph(Node node) {
//       if (node == null) {
//             return null;
//         }
//         Map<Node, Node> visited = new HashMap<>();
//         Queue<Node> queue = new LinkedList<>();
//         queue.add(node);
//         visited.put(node, new Node(node.val,new ArrayList<>()));
//         while (!queue.isEmpty()) {
//             Node curr = queue.poll();
//             for (Node neighbor : curr.neighbors) {
//                 if (!visited.containsKey(neighbor)) {
//                     visited.put(neighbor, new Node(neighbor.val,new ArrayList<>()));));
//                     queue.add(neighbor);
//                 }
//                 visited.get(curr).neighbors.add(visited.get(neighbor));
//             }
//         }
//         return visited.get(node);
//     }
// }
