package Linked;

public class MergeTwoSortedList {

    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addNodes(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode start = head;
        for(int i=1; i<nums.length ; i++) {
            ListNode temp = new ListNode(nums[i]);
            head.next = temp;
            head = head.next;
        }
        return start;
    }

    public ListNode solution(ListNode a, ListNode b) {
        ListNode curr = null;
        if(a==null) {
            return b;
        }
        if(b==null) {
            return a;
        }
        if(a.val<=b.val) {
            curr = new ListNode(a.val);
            a=a.next;
        } else {
            curr = new ListNode(b.val);
            b=b.next;
        }
        ListNode res = curr;
        while(a!=null && b!=null) {
            if(a.val<=b.val) {
                ListNode temp = new ListNode(a.val);
                curr.next = temp;
                a=a.next;
            } else {
                ListNode temp = new ListNode(b.val);
                curr.next = temp;
                b=b.next;
            }
            curr = curr.next;
        }
        while(a!=null) {
            ListNode temp = new ListNode(a.val);
            curr.next = temp;
            curr = curr.next;
            a=a.next;
        }
        while(b!=null) {
            ListNode temp = new ListNode(b.val);
            curr.next = temp;
            curr = curr.next;
            b=b.next;
        }
        return res;
    }

    public static void main(String[] args) {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode l1 = mergeTwoSortedList.addNodes(new int[]{5,7,8,30});
        ListNode l2 = mergeTwoSortedList.addNodes(new int[]{10,20});
        ListNode res = mergeTwoSortedList.solution(l1, l2);
        ListNode curr = res;
        while(curr!=null) {
            System.out.print(curr.val+"\t");
            curr = curr.next;
        }
    }
}
