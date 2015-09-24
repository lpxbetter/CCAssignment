package ch4;

import java.util.HashMap;

/**
 * Created by lipingxiong on 9/23/15.
 */
public class pathCount_4_12 {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            this.val = x;
        }
    }
    HashMap<Integer,Integer> sumCountMap = new HashMap<>();
    public int pathCount(TreeNode root, int target){
        updateMap(0,1); // At beginning,cumuSum==0, its count is 1;
        return pathCount(root,0,target);
    }
    // cumulative sum
    public int pathCount(TreeNode root, int cumuSum,int target){
        if(root == null) return 0;
        cumuSum += root.val;
        // check whether there is cumuSum - target in map. IF it is,how many are there.
        int diff = cumuSum - target;
        int pathNum = (sumCountMap.containsKey(diff)) ? sumCountMap.get(diff): 0;
        //update map
        updateMap(cumuSum, 1); // increament the count of cumuSum

        pathNum += pathCount(root.left, cumuSum, target);
        pathNum += pathCount(root.right, cumuSum, target);

        updateMap(cumuSum, -1);// recover the count of cumuSum
        return pathNum;
    }
    public void updateMap(int key,int diff){
        if(!sumCountMap.containsKey(key)) sumCountMap.put(key,0);
        sumCountMap.put(key,sumCountMap.get(key) + diff);
    }
}
