package ch4;

/**
 * Created by lipingxiong on 9/22/15.
 */
public class sortedArrToBST_4_2 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public TreeNode sortedArrayToBST(int[] num) {
        if(num==null || num.length==0)
            return null;
        return doConvert(num,0,num.length-1);
    }
    public TreeNode doConvert(int[] num,int l, int r){
        if(l>r) return null;
        int m=(l+r)/2;
        TreeNode root=new TreeNode(num[m]);
        root.left=doConvert(num,l,m-1);
        root.right=doConvert(num,m+1,r);
        return root;
    }
}
