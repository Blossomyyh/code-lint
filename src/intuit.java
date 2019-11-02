import java.util.*;

public class intuit {
    //build tree with array
    public class Tree {
        Node root;

        // Tree Node
        class Node {
            int data;
            Node left, right;
            Node(int data)
            {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }

        public Node insertLevelOrder(int[] arr, Node root,
                                 int i)
        {
            // Base case for recursion
            if (i < arr.length) {
                Node temp = new Node(arr[i]);
                root = temp;

                // insert left child
                root.left = insertLevelOrder(arr, root.left,
                        2 * i + 1);

                // insert right child
                root.right = insertLevelOrder(arr, root.right,
                        2 * i + 2);
            }
            return root;
        }

    }


    /**
     * 1 --> 2 --> 4 --> 8
     BACKTRACK 8 --> 4
     4 --> 9 (ONE NODE FOUND, return True)
     BACKTRACK 9 --> 4 --> 2
     2 --> 5 --> 10
     BACKTRACK 10 --> 5
     5 --> 11 (ANOTHER NODE FOUND, return True)
     BACKTRACK 11 --> 5 --> 2

     Start traversing the tree from the root node.
     If the current node itself is one of p or q, we would mark a variable mid as True and continue the search for the other node in the left and right branches.
     If either of the left or the right branch returns True, this means one of the two nodes was found below.
     If at any point in the traversal, any two of the three flags left, right or mid become True, this means we have found the lowest common ancestor for the nodes p and q.
     */
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.isLCA(root, p,q);
        return this.ans;
    }
    public boolean isLCA(TreeNode node, TreeNode p, TreeNode q){
        if(node==null) return false;
        //p or q occurred
        boolean curr = (node==p || node==q );
        //Left recursion
        boolean left = isLCA(node.left, p, q);
        //Right recursion
        boolean right = isLCA(node.right, p,q);

        //any two of them is true
        if(curr && left || curr &&right ||left&& right){
            this.ans = node;
        }

        return (curr||left||right);

    }
    /**
     * time O(N)
     * space O(N)
     */


    /**
     * Iterative using parent pointers
     * Start from the root node and traverse the tree.
     Until we find p and q both, keep storing the parent pointers in a dictionary.
     Once we have found both p and q, we get all the ancestors for p using the parent dictionary and add to a set called ancestors.
     Similarly, we traverse through ancestors for node q. If the ancestor is present in the ancestors set for p,
     this means this is the first ancestor common between p and q (while traversing upwards) and hence this is the LCA node.
     * @param root
     * @param p
     * @param q
     * @return
     */

    public TreeNode LGA(TreeNode root, TreeNode p, TreeNode q) {
        //tree traversal using stack
        Stack<TreeNode> stack = new Stack<>();
        //record every parent of the node
        Map<TreeNode, TreeNode> map = new HashMap();
        map.put(root, null);
        stack.push(root);
        //find p & q
        while(!map.containsKey(p) || !map.containsKey(q)){
            TreeNode node = stack.pop();
            if(node.left!=null){
                stack.push(node.left);
                map.put(node.left, node);
            }
            if(node.right!=null){
                stack.push(node.right);
                map.put(node.right, node);
            }

        }
        //process all ancestors for node p using parent pointers
        HashSet<TreeNode> setP = new HashSet<>();
        while(p!=null){
            setP.add(p);
            p = map.get(p);
        }
        //the first parent in q which appears also in p's set is the LCA
        while(!setP.contains(q)){
            q = map.get(q);
        }
        return q;

    }

    /**
     Initialize a queue, Q to keep a track of all the nodes in the graph with 0 in-degree.
     Iterate over all the edges in the input and create an adjacency list and also a map of node v/s in-degree.
     Add all the nodes with 0 in-degree to Q.
     The following steps are to be done until the Q becomes empty.
     Pop a node from the Q. Let's call this node, N.
     For all the neighbors of this node, N, reduce their in-degree by 1. If any of the nodes' in-degree reaches 0, add it to the Q.
     Add the node N to the list maintaining topologically sorted order.
     Continue from step 4.1.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree  = new int[numCourses];
        int[] order = new int[numCourses];
        // create adjList map
        for(int i = 0;i<prerequisites.length; i++){
            int course = prerequisites[i][0];
            int basic = prerequisites[i][1];
            List<Integer> courReq = adjList.getOrDefault(basic, new ArrayList<Integer>());
            courReq.add(course);
            adjList.put(basic, courReq);
            // record in-degree of each v
            indegree[course] +=1;
        }

        //add all v with 0 indegree to the queue;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i= 0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int i = 0;
        //process q until empty
        while(!q.isEmpty()){
            int node = q.remove();
            order[i] = node;
            i++;
            //reduce the indegree of each neighbour by 1
            if(adjList.containsKey(node)){
                for(int neighbour: adjList.get(node)){
                    indegree[neighbour]--;

                    //if it becomes 0 add it to Q
                    if(indegree[neighbour]==0){
                        q.add(neighbour);
                    }
                }
            }
        }

        //check if the topological sort is possible or not
        if(i==numCourses){
            return order;
        }

        return new int[0];


    }



}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
