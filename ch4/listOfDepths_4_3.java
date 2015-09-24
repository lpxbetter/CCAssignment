package ch4;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by lipingxiong on 9/23/15.
 */
public class listOfDepths_4_3 {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int val;

        TreeNode(int x) {
            this.val = x;
        }
    }
    // DFS method
    public void DFS( TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
        if(root == null ) return;
        LinkedList<TreeNode> list = null;

        if(lists.size() == level) { // haven't seen level i yet.
            list = new LinkedList<>();
            lists.add(list);// add list at the end of lists
        }
        else{
            list = lists.get(level);
        }
        list.add(root);
        DFS(root.left, lists, level + 1);
        DFS(root.right, lists, level + 1);
    }
    public ArrayList<LinkedList<TreeNode>> listOfDepth(TreeNode root){
        ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
        DFS(root,res,0);
        return res;
    }
}
