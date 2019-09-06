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
        int h1 = 0;
        int h2 = 0;
        TreeNode v = root;

        while (v.left != null){
            h1++;
            v = v.left;
        }
        while (v.right!= null){

        }
        return h1;
    }

}
