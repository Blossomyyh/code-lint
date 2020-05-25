package Tree;

import java.util.Arrays;
import java.util.HashMap;

public class BuildTree {


    public static TreeNode helper(int[] preorder, int idx, HashMap<Integer, Integer> map, int left, int right){
        //if there is no elelments to construct subtrees
        if(left==right) return null;
        //pick up idx element as a root
        int val = preorder[idx];
        TreeNode root = new TreeNode(val);

        //root splits inorder list
        int index = map.get(val);
        //recursion
        idx++;
        //left
        root.left = helper(preorder, idx, map,left, index);
        //right
        root.right = helper(preorder, idx, map, index+1, right);
        return root;

    }
    public static TreeNode bstFromPreorder(int[] preorder) {
        int  idx = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // inorder could be achieved by sorted
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);

        //build hashmap value ->its index
        for(int val: inorder){
            map.put(val, idx++);
        }
        return helper(preorder,0, map,0, inorder.length);
    }



    public static void main(String args[]){
        bstFromPreorder(new int[]{8,5,1,7,10,12});
    }

}
