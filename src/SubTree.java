public class SubTree {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public static Boolean isSubTree(TreeNode s, TreeNode t){
        String tree1= getTree(s, true);
        String tree2 = getTree(t,true);

        return tree1.indexOf(tree2)!=-1;
    }
    // time complexity = O(m+ n+ mn)   indexOf- take (mn)
    //traversal takes m^2
    //space complexity = O(max(n,m))

    public static String getTree(TreeNode m, Boolean left){
        //preorder
        if (m == null){
            if (left)
                return "#lnull";
            else
                return "rnull";
        }
        return "#"+m.val +getTree(m.left,true) + getTree(m.right, false);
    }

    public static Boolean istheSubtree(TreeNode s, TreeNode t){
        if (s!=null && t!= null){
            TreeNode m = traversal(s,t);

            if(m!=null && t!=null) {return getTree(m,t);}
            else return false;

        }else return false;

    }
    public static TreeNode traversal(TreeNode s, TreeNode t){
        if(s ==null) {return null;}
        else if(s.val == t.val){
            return s;
        }
        else
        return traversal(s.left, t);
    }

    public static Boolean getTree(TreeNode m, TreeNode t){
        if(m == null && t== null){
            return true;
        } else if(m.val != t.val){
            return false;
        }else if (m.val == t.val){
            getTree(m.left, t.left);
            getTree(m.right,t.right);
        }
        return true;
    }



    //todo: traversal && equals together to return the value
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    public boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
    public boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }

    public static void main(String arg[]){
        TreeNode m = new TreeNode(3);
        m.left = new TreeNode(4);
        m.right = new TreeNode(5);
        m.left.left = new TreeNode(1);
        m.left.right = new TreeNode(2);
        Boolean a = istheSubtree(m,m.left);
    }
}
