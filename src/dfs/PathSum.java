package dfs;


import java.util.LinkedList;

public class PathSum {
    public static boolean hasPathSum(BinaryTree.TreeNode root, int sum){
        if (root==null) return false;

        // todo: bfs use stack to pop and push -- in java is linkedlist
        LinkedList<BinaryTree.TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();

        stack.push(root);
        sumStack.push(sum - root.val);

        BinaryTree.TreeNode node;
        int cur;
        while (!stack.isEmpty()){
            node = stack.pop();
            cur = sumStack.pop();

            if (node.right== null && node.left==null && cur==0) return true;
            if (node.right != null){
                stack.push(node.right);
                sumStack.push(cur - node.right.val);
            }
            if (node.left!= null){
                stack.push(node.left);
                sumStack.push(cur - node.left.val);
            }
        }

        return false;
    }

    //dfs
    public boolean mPathSum(BinaryTree.TreeNode root, int sum) {
        if(root == null)  return false;
        if(root.left == null && root.right == null){
            if(root.val == sum){
                return true;
            }else return false;
        }else{
            sum -= root.val;
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
    }

}
