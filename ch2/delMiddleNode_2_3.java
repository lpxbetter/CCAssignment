package hw1;

/**
 * Created by lipingxiong on 9/14/15.
 */
public class delMiddleNode_2_3 {
    public static class ListNode{
        ListNode next;
        int val;
        public ListNode(int x){
            this.next = null;
            this.val = x;
        }
    }
    public static boolean delMiddleNode(ListNode node){
        if(node == null || node.next == null) return false;
        node.val = node.next.val;
        node.next = node.next.next;
        return true;
    }
}
