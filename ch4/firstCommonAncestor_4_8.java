package ch4;

/**
 * Created by lipingxiong on 9/22/15.
 */
public class firstCommonAncestor_4_8 {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            this.val = x;
        }
    }
    public static TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) {
            return null;
        }
        if (root.val == n1.val || root.val == n2.val) return root; //found, root is one of those two
        TreeNode resL = findLCA(root.left, n1, n2);
        TreeNode resR = findLCA(root.right, n1, n2);
//        if(resL!=null && )
        if (resL != null && resR != null) return root;
        if (resL == null && resR == null) return null;
        return (resL == null) ? resR : resL;
    }

    /*
     * For test
     */
    public static void printResult(String str, TreeNode resNode) {
        System.out.println(str);
        if (resNode == null) System.out.println("null");
        else System.out.println(resNode.val);
    }

    public static void main(String[] args) {
    /*
     1
    / \
   2   3
   / \
  4   5
  */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode resNode = findLCA(root, new TreeNode(4), new TreeNode(5));
        printResult("LCA of 4,5:", resNode);

        resNode = findLCA(root, new TreeNode(4), new TreeNode(3));
        printResult("LCA of 4,3:", resNode);

        // When one node is the parent of another
        resNode = findLCA(root, new TreeNode(1), new TreeNode(3));
        printResult("LCA of 1,3:", resNode);

        // When one node is not in the tree
        resNode = findLCA(root, new TreeNode(1), new TreeNode(6));
        printResult("LCA of 1,6:", resNode);

        // When both nodes are not in the tree
        resNode = findLCA(root, new TreeNode(6), new TreeNode(7));
        printResult("LCA of 6,7:", resNode);

    }
}

