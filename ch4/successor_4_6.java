package ch4;

/**
 * Created by lipingxiong on 9/23/15.
 */
public class successor_4_6 {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int val;

        TreeNode(int x) {
            this.val = x;
        }
    }
    TreeNode inorderSucc(TreeNode node){
        if(node == null) return null;
        if(node.right != null){
            return leftMostChild(node);
        }
        //doesn't have right child; go up until we're on the left child side;
        // If we can't find left child, then we're on the rightMost node of the tree, then there is no
        // in-order successor, we should return null
        TreeNode cl = node; // child node
        TreeNode pa = node.parent; //parent node
        while(pa != null && pa.left != cl){ //cur node is not the left child of pa.
            cl = pa;
            pa = pa.parent;
        }
        return pa;
    }

    public TreeNode leftMostChild(TreeNode node){
        if(node == null) return null;
        if(node.left != null) node = node.left; // go to the leftMost
        return node;
    }
}
