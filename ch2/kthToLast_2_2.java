package hw1;

import java.util.List;

/**
 * Created by lipingxiong on 9/14/15.
 Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class kthToLast_2_2 {
    public static class ListNode{
        ListNode next;
        int val;
        public ListNode(int x){
            this.next = null;
            this.val = x;
        }
    }
    //runner move k steps first, then move walker and runner at the same time
    public static ListNode kthToLast(ListNode head,int k){
        if(k<=0) return null;
        ListNode walker = head;
        ListNode runner = head;
        for(int i=0;i<k;i++){
            if(runner == null) return  null; //invalid k, k>len of list
            runner = runner.next;
        }
        while(runner !=null){
            runner = runner.next;
            walker = walker.next;
        }
        return walker;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode res =  kthToLast(head,3);
        System.out.println(res.val);
    }
}
