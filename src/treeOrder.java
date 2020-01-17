import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class treeOrder {
    public static List<Integer> TreeOrder(TreeNode root){

        List<Integer> res = new ArrayList<>();
        if(root== null) return res;
        inorder(res, root);
        return res;

    }

    /**
     * todo: Inorder  : left root right
     * todo: Preorder : root left right
     * todo: Postorder: left right root
     *
     *
     * @param res
     * @param node
     * @return
     */
    public static List<Integer> inorder(List<Integer> res, TreeNode node){
        if(node==null) return res;


        res = inorder(res, node.left);
        res.add(node.val);

        res = inorder(res, node.right);
        return res;
    }



    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        //if(root== null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty() ){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }


    /**
     * post order
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack= new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!= null)
                stack.push(node.left);
        }
        return res;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack= new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.addFirst(node.val);
            //todo addFirst(reverse) --- left first and right next---because we need to reverse the sequence
            if(node.left!=null)
                stack.push(node.left);
            if(node.right!= null)
                stack.push(node.right);
        }
        return res;
    }
}
