package ch4;

import java.util.Random;

/**
 * Created by lipingxiong on 9/23/15.
 */
public class randomNode_4_11 {

    public class TreeNode{
        private int val ;
        private int size;
        public TreeNode left;
        public TreeNode right;
        //constructor
        public TreeNode(int x){
            val = x;
            size = 1;
        }
        public int size(){return size;} // get size
        public int data(){return val;} // get data

        public TreeNode getIthNode(int i){
            int leftSize = left == null ? 0: left.size;
            if(i == leftSize) return this; // found
            else if(i<leftSize) return left.getIthNode(i);
            else return right.getIthNode( i - leftSize - 1);
        }
        public void insertInOrder(int x){
            if(x<=val){
                if(left==null) { left = new TreeNode(x);}
                else left.insertInOrder(x);
            }
            else{
                if(right == null) right=new TreeNode(x);
                else right.insertInOrder(x);
            }
            size++;
        }
    }

    public class Tree{
        TreeNode root = null;
        public int size(){ // get size
            return root==null ?  0 : root.size();
        }
        // get a random node from the tree
        public TreeNode getRandomNode(){
            if(root==null) return null;
            // get a random number between 0-size
            Random random = new Random();
            int i = random.nextInt(size());

            return root.getIthNode(i);
        }
        // insert node to the tree by in-order order
        public void insertInOrder(int value){
            if(root==null) root=new TreeNode(value);
            else root.insertInOrder(value);
        }
    }
}
