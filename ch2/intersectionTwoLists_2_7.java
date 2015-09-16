package hw1;

/**
 * Created by lipingxiong on 9/15/15.
 */
public class intersectionTwoLists_2_7 {

//    Intersection of Two Linked Lists

    private static class ListNode{
        ListNode next;
        int val;
        public ListNode(int x){
            this.next = null;
            this.val = x;
        }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur = headA;
        int len1 = 0;
        while(cur != null){
            len1++;
            cur = cur.next;
        }
        cur = headB;
        int len2 = 0;
        while(cur!= null){
            len2++;
            cur = cur.next;
        }
        if(len1 < len2) return getIntersectionNode(headB,headA);
        int diff = len1 - len2;
        System.out.println("diff=" + diff);
        // len1 > len2 ? diff = len1 - len2 : len2 - len1 ;
        cur = headA;
        for(int i=0;i<diff;i++){
            cur = cur.next;
        }
        headA = cur;
        while(headA != null && headB != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static void main (String[] args){
        ListNode headA = new ListNode(0);
        ListNode headB = new ListNode(1);
        headB.next = new ListNode(3);
        headB.next.next = headA;
        ListNode res = getIntersectionNode(headA, headB);
        System.out.println(res.val);
    }
}
