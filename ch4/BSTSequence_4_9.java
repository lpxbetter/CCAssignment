package ch4;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by lipingxiong on 9/23/15.
 */
public class BSTSequence_4_9 {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            this.val = x;
        }
    }
    // root as the prefix, recursively get the left and right arrays, and then prepend each array with the prefix.
    ArrayList<LinkedList<Integer>> allSequence(TreeNode root){
        ArrayList<LinkedList<Integer>> res = new ArrayList<>();
        if(root == null){
            res.add(new LinkedList<Integer>());
            return res;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.val);

        ArrayList<LinkedList<Integer>> leftSeq = allSequence(root.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequence(root.right);

        for(LinkedList<Integer> left : leftSeq){
            for(LinkedList<Integer> right : rightSeq){
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                res.addAll(weaved);
            }
        }
        return res;
    }
// weave two lists, the order of elements remains unchanged in each list.
    public void weaveLists(LinkedList<Integer> list1, LinkedList<Integer> list2, ArrayList<LinkedList<Integer>> res,
        LinkedList<Integer> prefix){
        // one weave is created, add it to the result Arraylists.
        if(list1.size() ==0 || list2.size()==0){
            LinkedList<Integer> item = (LinkedList<Integer>)prefix.clone();
            item.addAll(list1);
            item.addAll(list2);
            res.add(item);
            return;
        }

        int head1 = list1.removeFirst() ; // get first elem
        prefix.addLast(head1);
        weaveLists(list1,list2, res, prefix);
        prefix.removeLast(); // recover
        list1.addFirst(head1); // recover

        int head2 = list2.removeFirst();
        prefix.addLast(head2);
        weaveLists(list1, list2, res, prefix);
        prefix.removeLast(); //recover
        list2.addFirst(head2); // recover
    }
}
