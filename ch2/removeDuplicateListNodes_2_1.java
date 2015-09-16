package hw1;

/**
 * Created by lipingxiong on 9/14/15.
 */
public class removeDuplicateListNodes_2_1 {
    public static class ListNode{
        ListNode next;
        int val;
        public ListNode(int x){
            this.next = null;
            this.val = x;
        }
    }
    public void removeDuplicate(ListNode head){
        if(head == null) return;
        ListNode walker = head;
        ListNode runner = null;
        while(walker!=null){
            runner = walker;
            while(runner.next != null){
                if(runner.next.val == walker.val){
                    runner.next = runner.next.next;
                }
                else{
                    runner = runner.next;
                }
            }
            walker = walker.next;
        }

    }
    public static void main(String args[]){
        removeDuplicateListNodes_2_1 rmvDup = new removeDuplicateListNodes_2_1();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next = new ListNode(1);
        rmvDup.removeDuplicate(head);
    }
}
