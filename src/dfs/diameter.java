package dfs;

public class diameter {
    //If we knew the maximum length arrows L, R for each child, then the best path touches L + R + 1 nodes, length is L+R.
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        res = 0;
        dfs(root);
        return res;
    }
    public int dfs(TreeNode node){
        if(node==null) return 0;
        int L = dfs(node.left);
        int R  =dfs(node.right);
        res = Math.max(res, L+R);
        return Math.max(L,R)+1;
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.left = left;
          this.right = right;
      }
}