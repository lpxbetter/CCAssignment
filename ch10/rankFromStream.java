package ch10;

/**
 * Created by lipingxiong on 10/1/15.
 * 10.10
 */

public class rankFromStream {
    public class TreeNode {
        public int left_size = 0;
        public TreeNode left,right;
        public int data;
        public TreeNode(int x){
            data = x;
        }
        public void insert(int x){
            // insert to the left
            if(x <= this.data){
                if(left != null) left.insert(x);
                else left = new TreeNode(x);
                left_size++;
            }
            // insert to the right
            else {
                if(right!=null) right.insert(x);
                else right = new TreeNode(x);
            }
        }
        public int getRank(int x){
            if(x == data ){
                return left_size;//elements of the left subtree will be less than x
            }
            else if(x<data){
                return left==null ? -1:left.getRank(x);
            }
            else{
                int right_rank = right == null? -1 : right.getRank(x);
                return right_rank == -1? -1 : left_size + 1 + right_rank;
            }
        }
    }

    TreeNode root = null;
    //construct the tree from the stream data
    void trackStream(int x) {
        if (root == null) root = new TreeNode(x);
        else root.insert(x);
    }
}

