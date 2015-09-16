package hw1;

/**
 * Created by lipingxiong on 9/14/15.
 */
public class partitionList_2_4 {
    public static class ListNode{
        ListNode next;
        int val;
        public ListNode(int x){
            this.next = null;
            this.val = x;
        }
    }
    /*
Use two pointer, one pointer point to the last elem that's less than x, The another one scan the whole list
    If cur elem < x, move it to the front.and update the first pointer.
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode walker = helper;
        ListNode runner = helper;
        while (runner.next != null) {
            if (runner.next.val < x) {
                if (walker != runner) {
                    ListNode next = runner.next.next;
                    runner.next.next = walker.next;
                    walker.next = runner.next;
                    runner.next = next;
                } else
                    runner = runner.next;
                walker = walker.next;
            } else {
                runner = runner.next;
            }
        }
        return helper.next;
    }
}
