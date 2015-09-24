package ch4;

/**
 * Created by lipingxiong on 9/22/15.
 */
public class checkBalanced_4_4 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public boolean isBalanced(TreeNode root) {
        int res = helper(root);
        return res == -1 ? false:true;
    }
    public static int helper(TreeNode root ){
        if(root==null) return 0;
        int left=helper(root.left);
        if(left==-1) return -1;
        int right=helper(root.right);
        if(right==-1) return -1;
        if(Math.abs(left- right)>1) return -1;
        return Math.max(left,right)+1;
    }

}
