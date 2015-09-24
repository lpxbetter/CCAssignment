package ch4;

/**
 * Created by lipingxiong on 9/22/15.
 */
public class isBST_4_5 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean helper(TreeNode root, int min, int max)
    {
        if(root == null)
            return true;
        if(root.val==Integer.MIN_VALUE && root.left!=null) return false;
        if(root.val==Integer.MAX_VALUE && root.right!=null) return false;

        if(root.val <= min || root.val >= max)
            return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
