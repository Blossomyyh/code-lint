import java.util.ArrayList;
import java.util.List;

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
}
