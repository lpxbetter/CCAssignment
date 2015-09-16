package hw1;

/**
 * Created by lipingxiong on 9/14/15.
 */
public class addTwoNumbers_2_5 {
    public static class ListNode{
        ListNode next;
        int val;
        public ListNode(int x){
            this.next = null;
            this.val = x;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode pre = l3;
        int carry = 0;
        while(l1!=null && l2!=null){
            int tmp= l1.val + l2.val + carry;
            ListNode node = new ListNode(tmp%10);
            carry = tmp / 10;
            pre.next = node;
            pre = pre.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int tmp = l1.val + carry;
            ListNode node = new ListNode( tmp % 10);
            carry = tmp / 10;
            pre = pre.next = node;
            l1=l1.next;

        }
        while(l2!=null){
            int tmp = l2.val + carry;
            ListNode node = new ListNode(tmp % 10);
            carry = tmp/10;
            pre = pre.next = node;
            l2=l2.next;
        }
        if(carry>0){
            ListNode node = new ListNode(carry);
            pre.next = node;
        }
        return l3.next;
    }
}
