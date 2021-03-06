package dfs;

import java.util.LinkedList;

public class BinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int height(int[] t){
        return (int) Math.sqrt(t.length + 1);
        /**
         * 2ˆn - 1 = node (all)
         *
         * Math.pow(a,b) = aˆb
         *
         * .exp(a) = eˆa
         *
         * .sqrt(a) = the square root of a value
         */
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right) ) + 1;
        /**
         * time complexity O[n]
         * space complexity O(logn)balanced - O(n)left/right one node
         *
         *  in the extreme case the overhead of call stack might even lead to *stack overflow*.
         */
    }


    /**
     * tail recursion
     */
//    to optimize the  the memory allocation of call stack by reusing the same space for every recursive call,
//
//    class Solution {
//
//        private:
//        // The queue that contains the next nodes to visit,
//        //   along with the level/depth that each node is located.
//        queue<pair<TreeNode*, int>> next_items;
//        int max_depth = 0;
//
//        /**
//         * A tail recursion function to calculate the max depth
//         *   of the binary tree.
//         */
////        int next_maxDepth() {
//
//            if (next_items.size() == 0) {
//                return max_depth;
//            }
//
//            auto next_item = next_items.front();
//            next_items.pop();
//
//            auto next_node = next_item.first;
//            auto next_level = next_item.second + 1;
//
//            max_depth = max(max_depth, next_level);
//
//            // Add the nodes to visit in the following recursive calls.
//            if (next_node->left != NULL) {
//                next_items.push(make_pair(next_node->left, next_level));
//            }
//            if (next_node->right != NULL) {
//                next_items.push(make_pair(next_node->right, next_level));
//            }
//
//            // The last action should be the ONLY recursive call
//            //   in the tail-recursion function.
//            return next_maxDepth();
//        }
//
//        public:
//        int maxDepth(TreeNode* root) {
//            if (root == NULL) return 0;
//
//            // clear the previous queue.
//            std::queue<pair<TreeNode*, int>> empty;
//            std::swap(next_items, empty);
//            max_depth = 0;
//
//            // push the root node into the queue to kick off the next visit.
//            next_items.push(make_pair(root, 0));
//
//            return next_maxDepth();
//        }

    /** iteration
     * Stack in Java using LinkedList
     * @param root
     * @return
     *
     * Time O(n)
     * Space OSpace complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only left child node, the recursion call would occur
        N times (the height of the tree), therefore the storage to keep the call stack would be O(N). But in the average case (the tree is balanced), the height of the tree would be
    log(N). Therefore, the space complexity in this case would be
    O(log(N)).
     */
    public static int maxHeightNode(TreeNode root){
        int max = 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> num = new LinkedList<>();

        if (root == null) return 0; // don;t forget the initial one
        list.add(root);
        num.add(1);
        int current = 1;
        while (!list.isEmpty()){
            root = list.pollLast();
            current = num.pollLast();

            if (root!= null){
                max = Math.max(current, max);
                list.add(root.left);
                list.add(root.right);
                num.add(current + 1);
                num.add(current +1);
            }
        }
        return max;

    }

    public static void main(String arg[]){
        // Declaring a LinkedList
        LinkedList list = new LinkedList();

        // adding queue entry of people
        // in order
        list.add("Astha");
        list.add("Shambhavi");
        list.add("Nikhil");
        list.add(null);

        // printing the list
        System.out.println("The initial queue is : " + list);

        System.out.print("The order of exit is : ");
    }

}
