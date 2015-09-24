package ch4;

/**
 * Created by lipingxiong on 9/23/15.
 */
public class subTree_4_10 {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            this.val = x;
        }
    }
    boolean subTree(TreeNode t1,TreeNode t2) {
        if(t2 == null) return true; // empty tree is a subtree of any tree
        if(t1 == null) return false;
        if(t1.val == t2.val && matchTree(t1,t2)){
            return true;
        }
        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }
    boolean matchTree(TreeNode t1, TreeNode t2){
        if(t1 ==null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        return matchTree(t1.left,t2.left) && matchTree(t1.right,t2.right);
    }

}
