package hw1;

/**
 * Created by lipingxiong on 9/15/15.
 */
public class isPalindrom_2_6 {
    public static class ListNode{
        ListNode next;
        int val;
        public ListNode(int x){
            this.next = null;
            this.val = x;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        if(head ==null) return true;
        if(head.next==null) return true;
        if(head.next.next==null) return head.val == head.next.val;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode r = head;// runner
        ListNode w = head; // walker
        ListNode last = head;
        w = w.next;
        do{
            r = r.next.next;
//            System.out.println("w="+w.val);
//            System.out.println("r="+r.val);
            // reverse : put w in front of last
            last.next = w.next;
            w.next = dummy.next;
            dummy.next = w;
            w = last.next;
        }while(r.next!=null && r.next.next!=null);
        ptrList(dummy.next);
        ListNode h1 = null;
        ListNode h2 = null;
        //odd numbers of elements, the mid elem can be skipped
        if(r.next == null){
            h1 = dummy.next.next;
        }
        else{
            h1 = dummy.next;
        }
        h2 = last.next;
        System.out.println(h1.val + " " +h2.val);
        while(h2 != null){
            if(h1.val != h2.val) return false;
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }

    public static void ptrList(ListNode head){
        while(head!=null){
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }
    public static ListNode createList(int[] A){
        ListNode head = new ListNode(A[0]);
        ListNode pre = head;
        for(int i=1;i<A.length;i++){
            ListNode newNode = new ListNode(A[i]);
//            System.out.print(head.val);
            pre.next = newNode;
            pre = pre.next;
        }
        return head;
    }
    public static void main(String[] args){
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);
        ListNode head = createList(new int[]{1,0,0,0,0,1});
//        ptrList(head);
        System.out.println(isPalindrome(head));
        head = createList(new int[]{1,2,3,2,1});
//        ptrList(head);
//        System.out.println(isPalindrome(head));
    }

}
