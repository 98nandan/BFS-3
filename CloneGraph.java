// Time Complexity: O(V + E) where V is vertices and E is edges.
// Space Complexity: O(V) where V is vertices.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

class CloneGraph {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        map = new HashMap<>();
        // BFS approach.
        // Queue<Node> q = new LinkedList<>();
        // Node copyNode = clone(node);
        // q.add(node);
        // while(!q.isEmpty()) {
        //     Node curr = q.poll();
        //     List<Node> neighbors = curr.neighbors;
        //     for(Node n: neighbors) {
        //         if(!map.containsKey(n)) {
        //             clone(n);
        //             q.add(n);
        //         }
        //         map.get(curr).neighbors.add(map.get(n));    // First get deep copy of node, and then add deep copy of neighbors.
        //     }
        // }
        
        // DFS approach
        dfs(node);
        return map.get(node);       // return copyNode;      
        
    }
    
    private void dfs(Node node) {
        // base
        if(map.containsKey(node)) return;
        
        // logic
        clone(node);
        List<Node> neighbors = node.neighbors;
        for(Node neighbor: neighbors) {
            dfs(neighbor);
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }
    
    private Node clone(Node node) {
        if(map.containsKey(node)) return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    } 
}